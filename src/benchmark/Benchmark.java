package benchmark;

import sorting.*;
import utils.SortUtils;
import utils.interfaces.SortMethod;

import java.util.Arrays;

public class Benchmark {

    public static void testOnSingleArray(int[] arr) {
        runSingle("SelectionSort", arr, SelectionSort::sort);
        runSingle("InsertionSort", arr, InsertionSort::sort);
        runSingle("MergeSort", arr, MergeSort::sort);
        runSingle("QuickSort", arr, QuickSort::sort);
    }

    public static void runScalingBenchmark(int[] sizes, int trials) {
        warmup();

        for (int size : sizes) {
            System.out.println("\n Array size: " + size);

            // to avoid too long O(n²) sort on SelectionSort and InsertionSort
            if (size <= 20_000) {
                runAverageBenchmark("SelectionSort", size, trials, SelectionSort::sort);
                runAverageBenchmark("InsertionSort", size, trials, InsertionSort::sort);
            }

            runAverageBenchmark("MergeSort", size, trials, MergeSort::sort);
            runAverageBenchmark("QuickSort", size, trials, QuickSort::sort);
        }
    }

    // honestly, not my idea but great advice from senior developer to decrease JIT compilation
    private static void warmup() {
        System.out.println("Warming up...");

        int[] tmp = SortUtils.randomArray(50_000);

        for (int i = 0; i < 10; i++) {
            runQuiet(tmp, MergeSort::sort);
            runQuiet(tmp, QuickSort::sort);
        }
    }

    private static void runSingle(String name, int[] arr, SortMethod method) {
        double time = measureWithCopy(arr, method);
        System.out.printf("%s took: %.3f ms%n", name, time);
    }

    private static void runAverageBenchmark(String name, int size, int trials, SortMethod method) {
        double sumRandom = 0;
        double sumWorst = 0;

        for (int t = 0; t < trials; t++) {
            sumRandom += measureWithCopy(SortUtils.randomArray(size), method);
            sumWorst  += measureWithCopy(SortUtils.worstCaseArray(size), method);
        }

        System.out.printf("%-15s Avg random: %.3f ms | Worst: %.3f ms%n",
                name, sumRandom / trials, sumWorst / trials);
    }

    private static double measureWithCopy(int[] source, SortMethod method) {
        int[] copy = Arrays.copyOf(source, source.length);
        double ms = measure(copy, method);

        if (!SortUtils.isSorted(copy))
            throw new IllegalStateException("Sorting error!");

        return ms;
    }

    private static void runQuiet(int[] source, SortMethod method) {
        int[] copy = Arrays.copyOf(source, source.length);
        method.sort(copy);
    }

    private static double measure(int[] arr, SortMethod method) {
        long start = System.nanoTime();
        method.sort(arr);
        return (System.nanoTime() - start) / 1_000_000.0;
    }
}
