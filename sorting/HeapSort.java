package sorting;

import java.io.*;
import java.util.*;

/* 
 * Time Complexity: O(N log N)
Auxiliary Space: O(log n), due to the recursive call stack. However, auxiliary space can be O(1) for iterative implementation.

Important points about Heap Sort:
Heap sort is an in-place algorithm. 
Its typical implementation is not stable but can be made stable (See this)
Typically 2-3 times slower than well-implemented QuickSort.  The reason for slowness is a lack of locality of reference.
Advantages of Heap Sort:
Efficient Time Complexity: Heap Sort has a time complexity of O(n log n) in all cases. This makes it efficient for sorting large datasets. The log n factor comes from the height of the binary heap, and it ensures that the algorithm maintains good performance even with a large number of elements.
Memory Usage – Memory usage can be minimal (by writing an iterative heapify() instead of a recursive one). So apart from what is necessary to hold the initial list of items to be sorted, it needs no additional memory space to work
Simplicity –  It is simpler to understand than other equally efficient sorting algorithms because it does not use advanced computer science concepts such as recursion.
Disadvantages of Heap Sort:
Costly: Heap sort is costly as the constants are higher compared to merge sort even if the time complexity is O(n Log n) for both.
Unstable: Heap sort is unstable. It might rearrange the relative order.
Efficient: Heap Sort is not very efficient when working with highly complex data. 
 */
public class HeapSort {

    public static void main(String[] args) {
        int inputArray[];

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

            System.out.println("Sorted Array : " + Arrays.toString(heapsort(inputArray)));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int[] heapsort(int intputArray[]) {
        int heapSize = intputArray.length;

        for (int rootPosition = (heapSize / 2) - 1; rootPosition >= 0; rootPosition--) {
            maxHeap(intputArray, heapSize, rootPosition);
        }

        for (int i = heapSize - 1; i >= 0; i--) {
            swap(0, i, intputArray);
            maxHeap(intputArray, i, 0);
        }
        return intputArray;
    }

    public static void maxHeap(int arr[], int heapSize, int rootPosition) {

        int leftChild = 2 * rootPosition + 1;
        int rightChild = 2 * rootPosition + 2;

        int largest = rootPosition;

        if (leftChild < heapSize && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        if (rightChild < heapSize && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        if (largest != rootPosition) {
            swap(largest, rootPosition, arr);
            maxHeap(arr, heapSize, largest);
        }

    }

    public static boolean swap(int i, int j, int inputArray[]) {
        int temp = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = temp;
        return true;
    }
}
