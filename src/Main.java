import benchmark.Benchmark;
import utils.SortUtils;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final int SAMPLE_SIZE = 100;

    public static void main(String[] args) {
        System.out.println("\n>>> Starting...");

//        randomArraySort();
//        userInputArraySort();
        scaleSort();

        System.out.println("\n>>> Completed!");
    }

    // Random input array
    public static void randomArraySort() {
        int[] inputArray = SortUtils.randomArray(SAMPLE_SIZE);
        System.out.println("Random array: " + Arrays.toString(inputArray));
        Benchmark.testOnSingleArray(inputArray);
    }

    // Reading array from user
    public static void userInputArraySort() {
        int[] userInputArray = readFromConsole();
        System.out.println("Entered array: " + Arrays.toString(userInputArray));
        Benchmark.testOnSingleArray(userInputArray);
    }

    public static int[] readFromConsole() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " numbers: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    // Scaling arrays
    public static void scaleSort() {
        int[] sizes = {1_000, 10_000, 20_000, 50_000, 100_000, 200_000}; // slow option
//        int[] sizes = {1_000, 10_000, 20_000}; // quick option
        int trials = 5;

        System.out.println("\n>>> Sorting scalability:");
        Benchmark.runScalingBenchmark(sizes, trials);
    }
}
