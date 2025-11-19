package sorting;

// used open-source code - https://www.geeksforgeeks.org/dsa/selection-sort-algorithm-2/
// O(n²)

import utils.SortUtils;

public class SelectionSort {

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {

            int min_idx = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            SortUtils.swap(arr, i, min_idx);
        }
    }
}
