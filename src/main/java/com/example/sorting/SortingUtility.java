package com.example.sorting;

public class SortingUtility {

    // Gnome Sort
    public static <T extends Comparable<T>> void gnomeSort(T[] a) {
        int pos = 0;
        while (pos < a.length) {
            if (pos == 0 || a[pos].compareTo(a[pos - 1]) >= 0) {
                pos++;
            } else {
                // Swap a[pos] and a[pos - 1]
                swap(a, pos, pos - 1);
                pos--;
            }
        }
    }

    // Cocktail Shaker Sort
    public static <T extends Comparable<T>> void cocktailShakerSort(T[] a) {
        boolean swapped;
        do {
            swapped = false;
            // Forward pass
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i].compareTo(a[i + 1]) > 0) {
                    swap(a, i, i + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
            swapped = false;
            // Backward pass
            for (int i = a.length - 1; i > 0; i--) {
                if (a[i].compareTo(a[i - 1]) < 0) {
                    swap(a, i, i - 1);
                    swapped = true;
                }
            }
        } while (swapped);
    }

    // Shell Sort
    public static <T extends Comparable<T>> void shellSort(T[] a) {
        int n = a.length;
        int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1}; // Ciura gap sequence
        for (int gap : gaps) {
            if (gap >= n) continue; // Ignore gaps larger than the array length
            for (int i = gap; i < n; i++) {
                T temp = a[i];
                int j = i;
                while (j >= gap && a[j - gap].compareTo(temp) > 0) {
                    a[j] = a[j - gap];
                    j -= gap;
                }
                a[j] = temp;
            }
        }
    }

    // Utility method for swapping two elements in an array
    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {
        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }
}