package sorting;

import java.io.*;
import java.util.*;

/* Selection Sort is inplace array sorting with complexity O(n²) */
public class SelectionSort {

    public static void main(String[] args) {

        int inputArray[], sortedArray[] = null;

        System.out.println("Enter the array to sort with spaces between each number: ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] input = reader.readLine().split(" ");

            List<Integer> arrayList = new ArrayList<Integer>();
            for (String charNum : input) {
                arrayList.add(Integer.parseInt(charNum));
            }

            inputArray = arrayList.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();

            System.out.println("Select sorting Algorithm:");
            System.out.println("1.Selection Sort");
            System.out.println("2. Stable Selection Sort");
            int algoOption = Integer.parseInt(reader.readLine());
            switch (algoOption) {
                case 1:
                    sortedArray = selectionSort(inputArray);
                    break;
                case 2:
                    sortedArray = stableSelectionSort(inputArray);
                    break;
                default:
                    break;
            }

            System.out.println("Sorted Array : " + Arrays.toString(sortedArray));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*
     * Complexity: O(n²) Because of 2 for loops
     * Outer for loop to set min position
     * Inner for loop to find min value from unsorted array
     */

    public static int[] selectionSort(int unsortedArray[]) {

        for (int i = 0; i < unsortedArray.length - 1; i++) {
            int minIndex = i; // minIndex is the current value
            for (int j = i + 1; j < unsortedArray.length; j++) {
                if (unsortedArray[j] < unsortedArray[minIndex])
                    minIndex = j; // find minindex from the unsorted array
            }
            swap(i, minIndex, unsortedArray); // swap the minelement to the first place
            System.out.println("Pass " + (i + 1) + ": " + Arrays.toString(unsortedArray));
        }
        return unsortedArray;
    }

    // Helper Function to swap two elements in the array
    public static int[] swap(int i, int j, int array[]) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return array;
    }

    /*
     * Stable Selection Sort
     * Check this link why selection sort is not stable :
     * https://www.geeksforgeeks.org/stable-selection-sort/
     * Basically handling duplicates and shifting elements to the right and placing
     * the minelement at the first place
     * Similar time complexity with for(for+while) = O(n²)
     */
    public static int[] stableSelectionSort(int unsortedArray[]) {

        for (int i = 0; i < unsortedArray.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < unsortedArray.length; j++) {
                if (unsortedArray[j] < unsortedArray[minIndex]) {
                    minIndex = j;
                }
                int minValue = unsortedArray[minIndex];
                while (minIndex > i) {
                    unsortedArray[minIndex] = unsortedArray[minIndex - 1];
                    minIndex--;
                }
                unsortedArray[i] = minValue;
            }
            System.out.println("Pass " + (i + 1) + ": " + Arrays.toString(unsortedArray));
        }
        return unsortedArray;
    }

}
