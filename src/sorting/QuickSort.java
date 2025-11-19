package sorting;

// used open-source code - https://www.geeksforgeeks.org/dsa/quick-sort-algorithm/
// O(n log n) or worst - O(n²)

import utils.SortUtils;

public class QuickSort {

    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {

        int randomIndex = low + (int)(Math.random() * (high - low + 1));
        SortUtils.swap(arr, randomIndex, high);  // move random pivot to end

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                SortUtils.swap(arr, i, j);
            }
        }

        SortUtils.swap(arr, i + 1, high);
        return i + 1;
    }
}
