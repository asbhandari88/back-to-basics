package sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* Find partition and disect array on partition 
Time complexity : O(nlogn)
Ways to improve quicksort : 
Tail Recursion:
To minimize stack space usage, consider using tail recursion.
Recurse first into the smaller half of the array and use a tail call to recurse into the other half.
This ensures that at most O(log N) space is used during recursion.
Insertion Sort for Small Arrays:
For small arrays (where the length is less than a threshold), use insertion sort instead of quicksort.
Insertion sort has a smaller constant factor and is faster on small arrays.
You can leave such small arrays unsorted and run a single insertion sort pass at the end.
Median-of-Three Partitioning:
Instead of always choosing the first or last element as the pivot, consider using the median of a small sample of items.
Select three elements (e.g., first, middle, and last) and use their median as the pivot.
This can improve the performance of quicksort.
Dynamic Pivot Selection:
Experiment with dynamic pivot selection methods.
Some approaches include selecting the pivot based on the array’s characteristics or using random pivots.
Cutoff Threshold:
Determine a threshold (usually between 5 and 15) below which insertion sort is faster than quicksort.
For small arrays, switch to insertion sort to avoid unnecessary overhead. 
 */
public class QuickSort {

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

            sortedArray = quicksort(inputArray, 0, inputArray.length - 1);

            System.out.println("Sorted Array : " + Arrays.toString(sortedArray));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Select pivot as the last element in the array
     * 
     */
    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                swap(i, j, arr);
                i++;
            }
        }

        swap(i, high, arr);
        return i;
    }

    public static int[] quicksort(int arr[], int low, int high) {
        if (low < high) {
            int partition = partition(arr, low, high);
            quicksort(arr, low, partition - 1);
            quicksort(arr, partition + 1, high);
        }
        return arr;
    }

    public static boolean swap(int i, int j, int inputArray[]) {
        int temp = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = temp;
        return true;
    }

}
