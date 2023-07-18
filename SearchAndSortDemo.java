import java.util.Arrays;
import java.util.Scanner;

public class SearchAndSortDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input from user
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] array = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Enter the number to search: ");
        int searchValue = scanner.nextInt();

        // Choose search algorithm
        System.out.println("Select search algorithm:");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        int searchAlgorithm = scanner.nextInt();

        long startTime, endTime;
        switch (searchAlgorithm) {
            case 1:
                // Linear Search
                startTime = System.nanoTime();
                int linearIndex = linearSearch(array, searchValue);
                endTime = System.nanoTime();
                printSearchResult(linearIndex, searchValue, endTime - startTime);
                break;
            case 2:
                // Binary Search (requires sorted array)
                Arrays.sort(array);
                startTime = System.nanoTime();
                int binaryIndex = binarySearch(array, searchValue);
                endTime = System.nanoTime();
                printSearchResult(binaryIndex, searchValue, endTime - startTime);
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        // Choose sorting algorithm
        System.out.println("Select sorting algorithm:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Merge Sort");
        int sortAlgorithm = scanner.nextInt();

        switch (sortAlgorithm) {
            case 1:
                // Bubble Sort
                startTime = System.nanoTime();
                bubbleSort(array);
                endTime = System.nanoTime();
                printSortResult(array, endTime - startTime);
                break;
            case 2:
                // Merge Sort
                startTime = System.nanoTime();
                mergeSort(array);
                endTime = System.nanoTime();
                printSortResult(array, endTime - startTime);
                break;
            default:
                System.out.println("Invalid choice!");
        }

        scanner.close();
    }

    // Linear Search
    private static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search
    private static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    // Bubble Sort
    private static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort
    private static void mergeSort(int[] array) {
        if (array.length <= 1) {
            return;
        }

        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        mergeSort(left);
        mergeSort(right);

        merge(left, right, array);
    }

    private static void merge(int[] left, int[] right, int[] result) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }
    }

    // Print search result
    private static void printSearchResult(int index, int searchValue, long executionTime) {
        if (index == -1) {
            System.out.println(searchValue + " not found in the array.");
        } else {
            System.out.println(searchValue + " found at index " + index);
        }
        System.out.println("Search execution time: " + executionTime + " nanoseconds");
    }

    // Print sort result
    private static void printSortResult(int[] array, long executionTime) {
        System.out.println("Sorted array: " + Arrays.toString(array));
        System.out.println("Sort execution time: " + executionTime + " nanoseconds");
    }
}