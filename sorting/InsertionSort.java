package sorting;

import java.io.*;
import java.util.*;

/* The complexity of Insertion sort 

Time Complexity: O(N²)
 - Best for sorted and small arrays 
 - For sorted arrays Time complexity O(n)
Auxiliary Space: O(1)
- Inplace sorting 
- Insertion sort is like arranging play deck cards
 */

public class InsertionSort {
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

            sortedArray = insertionsort(inputArray);

            System.out.println("Sorted Array : " + Arrays.toString(sortedArray));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Move elements of arr[0..i-1], that are
     * greater than key, to one position ahead
     * of their current position
     */
    public static int[] insertionsort(int arr[]) {

        int currentValue;

        for (int i = 1; i <= arr.length - 1; i++) {
            currentValue = arr[i];
            int j = i - 1;

            while (j >= 0 && currentValue < arr[j]) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = currentValue;
        }

        return arr;
    }

}
