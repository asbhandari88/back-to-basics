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

            sortedArray = bubbleSort(inputArray);

            System.out.println("Sorted Array : " + Arrays.toString(sortedArray));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
}
