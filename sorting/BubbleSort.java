package sorting;

import java.io.*;
import java.util.*;

/* Inplace sorting so does not occupy additional space 
 * Time complexity : O(n²)
 * Space complexity: O(n)
 */
public class BubbleSort {

    public static void main(String[] args) {
        int inputArray[], sortedArray[];

        System.out.println("Enter the elements with space between them ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input[] = reader.readLine().split(" ");

            ArrayList<Integer> arrayList = new ArrayList<>();

            for (String element : input) {
                arrayList.add(Integer.parseInt(element));
            }

            inputArray = arrayList.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();

            System.out.println("Select Sorting technique");
            System.out.println("1. Normal Bubble Sort");
            System.out.println("2. Recursive Bubble Sort");

            int choice = Integer.parseInt(reader.readLine());

            switch (choice) {
                case 1:
                    sortedArray = bubbleSort(inputArray);
                    break;
                case 2:
                    sortedArray = recursiveBubbleSort(inputArray, inputArray.length);
                    break;
                default:
                    sortedArray = inputArray;
                    break;
            }

            System.out.println("Sorted Array : " + Arrays.toString(sortedArray));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * for i=arraylenght ,i--
     * for j=i+1 till i
     * check j and j+1 min and swap if necessary
     * For sorted array use a check swap flag . In the loop if swap happens then set
     * the flag to true .
     * But if swap does not happen than the flag remains false and array is sorted ,
     * so break out of loop.
     * Benefit is for sorted array the time complexity is O(n)
     */
    public static int[] bubbleSort(int unsortedArray[]) {
        boolean checkSwap;
        for (int i = unsortedArray.length - 1; i >= 0; i--) {
            checkSwap = false;
            for (int j = 0; j < i; j++) {
                if (unsortedArray[j] > unsortedArray[j + 1]) { // Check and swap current and next
                    checkSwap = swap(j, j + 1, unsortedArray);

                }
            }

            System.out.println("Pass " + (unsortedArray.length - i) + ": " + Arrays.toString(unsortedArray));
            System.out.println("Swap status: " + checkSwap);
            if (checkSwap == false) { // Check for a sorted array , do not need to execute if sorted
                break;
            }
        }
        return unsortedArray;
    }

    public static boolean swap(int i, int j, int inputArray[]) {
        int temp = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = temp;
        return true;
    }

    /*
     * Base case if array size is 1 return
     * Do a pass , find the max using swapping then you get the max value at last
     * field
     * Recursively call function with function(array,arraylength-1)
     */
    public static int[] recursiveBubbleSort(int inputArray[], int length) {

        if (length == 1) {
            return inputArray;
        }

        for (int i = 0; i < length - 1; i++) {
            if (inputArray[i] > inputArray[i + 1]) {
                swap(i, i + 1, inputArray);
            }
        }

        // Recur for remaining elements
        return recursiveBubbleSort(inputArray, length - 1);

    }
}
