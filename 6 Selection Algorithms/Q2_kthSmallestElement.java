
// Average Time Complexity: O(n)
// Worst-Case Time Complexity: O(n ^ 2)
// Space Complexity: O(1)

public class Q2_kthSmallestElement
{
    // 1. function to implement the kth smallest element (Selection Procedure)
    public static int selectionProcedure(int [] arr , int left , int right , int k)
    {
        // Base case: If there is only one element in the sub-array
        if (left == right)
        {
            return arr[left];
        }

        if(left < right)
        {
            // 1. Divide the array using partition algorithm
            int m = partition(arr , left , right);

            if(m == k - 1)
            {
                return arr[m];
            }
            else if (m < k - 1)
            {
                // 2. Conquer the sub-problems using recursion (right sub-array --> recursive call)
                return selectionProcedure(arr , m + 1 , right , k);
            }
            else
            {
                // 2. Conquer the sub-problems using recursion (left sub-array --> recursive call)
                return selectionProcedure(arr , left , m - 1 , k);
            }
        }
        return  -1;
    }

    // 2. function to do the partition of an array
    public static int partition(int [] arr , int left , int right)
    {
        int pivot = arr[left];
        int i = left;

        for(int j = left + 1; j <= right; j++)
        {
            if(arr[j] <= pivot)
            {
                i = i + 1;

                // swap arr[i] & arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[left] & arr[i]
        // to get the correct position of the pivot element

        int temp = arr[left];
        arr[left] = arr[i];
        arr[i] = temp;

        return i;
    }

    public static void main(String[] args)
    {
        int [] arr = {50, 30, 70, 90, 10, 34, 89, 98, 13};
        int n = arr.length;
        int k = 1;

        System.out.println("The " + k + "-th smallest element is : " + selectionProcedure(arr , 0 , n - 1 , k));
    }
}
