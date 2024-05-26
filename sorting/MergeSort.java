package sorting;

import java.io.*;
import java.util.*;

/* 
1. Time Complexity
Case	Time Complexity
Best Case	O(n*logn)
Average Case	O(n*logn)
Worst Case	O(n*logn)
Best Case Complexity - It occurs when there is no sorting required, i.e. the array is already sorted. The best-case time complexity of merge sort is O(n*logn).
Average Case Complexity - It occurs when the array elements are in jumbled order that is not properly ascending and not properly descending. The average case time complexity of merge sort is O(n*logn).
Worst Case Complexity - It occurs when the array elements are required to be sorted in reverse order. That means suppose you have to sort the array elements in ascending order, but its elements are in descending order. The worst-case time complexity of merge sort is O(n*logn).
2. Space Complexity
Space Complexity	O(n)
Stable	YES
The space complexity of merge sort is O(n). It is because, in merge sort, an extra variable is required for swapping.
 */
public class MergeSort {
    public static void main(String[] args) {

        int inputArray[];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the elements in the array with spaces");

        try {

            String input[] = reader.readLine().split(" ");

            ArrayList<Integer> arrayList = new ArrayList<>();

            for (String element : input) {
                arrayList.add(Integer.parseInt(element));
            }

            inputArray = arrayList.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();

            sort(inputArray, 0, inputArray.length - 1);
            System.out.println("Sorted Array " + Arrays.toString(inputArray));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void sort(int inputArray[], int low, int high) {

        if (low < high) {
            int mid = (low + high) / 2;
            sort(inputArray, low, mid);
            sort(inputArray, mid + 1, high);
            merge(inputArray, low, mid, high);
            System.out.println("Pass : " + Arrays.toString(inputArray));
        }

    }

    public static void merge(int inputArray[], int low, int mid, int high) {

        int leftSize = mid - low + 1;
        int rightSize = high - mid;

        int leftArray[] = new int[leftSize];
        int rightArray[] = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = inputArray[low + i];

        }

        for (int j = 0; j < rightSize; j++) {
            rightArray[j] = inputArray[mid + 1 + j];
        }
        int leftCounter = 0, rightCounter = 0, arrayCounter = low;
        while (leftCounter < leftSize && rightCounter < rightSize) {
            if (leftArray[leftCounter] <= rightArray[rightCounter]) {
                inputArray[arrayCounter] = leftArray[leftCounter];
                leftCounter++;
            } else {
                inputArray[arrayCounter] = rightArray[rightCounter];
                rightCounter++;
            }
            arrayCounter++;
        }

        while (leftCounter < leftSize) {
            inputArray[arrayCounter++] = leftArray[leftCounter++];
        }

        while (rightCounter < rightSize) {
            inputArray[arrayCounter++] = rightArray[rightCounter++];
        }

    }

}
