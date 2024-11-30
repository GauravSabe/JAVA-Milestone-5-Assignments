/*

Q1. Given an integer array, find the kth largest element using the quick select algorithm.

Input 1:
arr [] = {1,3,2,4,5,6,7} , k = 3

output 1 : 5

Input 2:
arr [] = {4,3,3,2,1} , k = 4

output 2 : 2

 */

// Average Time Complexity: O(n)
// Worst-Case Time Complexity: O(n ^ 2)
// Space Complexity: O(1)

public class Q1_KthLargestElement
{
    // Function to find the k-th largest element
    public static int selectionProcedure(int[] arr, int left, int right, int k)
    {
        int n = arr.length;
        // We need the (n - k)-th the smallest element for the k-th largest
        int targetIndex = n - k;

        // Base case: when only one element is left in the partition
        if (left == right)
        {
            return arr[left];
        }

        if (left <= right)
        {
            // Partition the array
            int m = partition(arr, left, right);

            // If partition index matches the target index
            if (m == targetIndex)
            {
                return arr[m];
            }
            else if (m < targetIndex)
            {
                // Search in the right sub-array
                return selectionProcedure(arr, m + 1, right, k);
            }
            else
            {
                // Search in the left sub-array
                return selectionProcedure(arr, left, m - 1, k);
            }
        }
        return -1;
    }

    // Partition function
    public static int partition(int[] arr, int left, int right)
    {
        int pivot = arr[left];
        int i = left;

        for (int j = left + 1; j <= right; j++)
        {
            if (arr[j] <= pivot)
            {
                i++;
                // Swap arr[i] & arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[left] & arr[i] to place pivot correctly
        int temp = arr[left];
        arr[left] = arr[i];
        arr[i] = temp;

        return i;
    }

    public static void main(String[] args)
    {
        int[] arr = {50, 30, 70, 90, 10, 34, 89, 98, 13};
        int k = 1;  // Find the 3rd largest element
        int n = arr.length;

        System.out.println("The " + k + "-th largest element is: " + selectionProcedure(arr, 0, n - 1, k));
    }
}

