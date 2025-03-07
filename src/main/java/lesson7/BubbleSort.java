package lesson7;

/** 
 * This example demonstrates the implementation of the famous Bubble sort algorithm.
 * (https://en.wikipedia.org/wiki/Bubble_sort)
 * 
 * Other, higher performing sorting algorithms are e.g. Merge sort and Quick sort
*/
public class BubbleSort {

    // Bubble sort sorts the provided integer array into ascending order
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        // The outer loop takes care of going through each index in the array
        for (int i = 0; i < n - 1; i++) {
            // The inner loop compares subsequent array value and switch their order
            // if they are in incorrect order (larger value is before the smaller value)
            for (int j = 0; j < n - i - 1; j++) {

                // Are the subsequent array values in wrong order?
                if (arr[j] > arr[j + 1]) {

                    // Vaihdetaan `j` ja `j+1` keskenään!
                    // In that case, switch the values between `j` and `j+1`
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            // Print the current result
            printArray(arr);
        }
    }

    // Helper method for printing an array
    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Example usage of the bubble sort
    public static void main(String[] args) {
        int[] arrayToSort = {64, 25, 90, 12, 22, 11};
        
        System.out.println("Original array:");
        printArray(arrayToSort);
        
        // Perform the bubble sort
        bubbleSort(arrayToSort);
        
        System.out.println("Sorted array:");
        printArray(arrayToSort);
    }
}
