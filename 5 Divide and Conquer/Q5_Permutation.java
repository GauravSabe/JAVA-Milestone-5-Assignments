/*
Q4. Given two arrays of equal size n and an integer k. The task is to permute both arrays such
that the sum of their corresponding element is greater than or equal to k i.e a[i] + b[i] >= k. The
task is to print “Yes” if any such permutation exists, otherwise print “No”.

input :
    a[] = {2, 1, 3},
    b[] = { 7, 8, 9 },
    k = 10.
output :
    Yes

input :
    a[] = {1, 2, 2, 1},
    b[] = { 3, 3, 3, 4 },
    k = 5.
output :
    No
 */

// TC = O(n log n)
// SC = O(n)
import java.util.*;

public class Q5_Permutation
{
    public static boolean isPossible(Integer [] arr1 , int [] arr2 , int n , int k)
    {
        // Sort the array arr1[] in decreasing order.
        Arrays.sort(arr1 , Collections.reverseOrder());

        // Sort the array arr2[] in increasing order.
        Arrays.sort(arr2);

        // Checking condition on each index.
        for (int i = 0; i < n; i++)
        {
            if (arr1[i] + arr2[i] < k)
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args)
    {
        Integer [] arr1 = {2, 1, 3};
        int [] arr2 = {7, 8, 9};

        int k = 10;
        int n = arr1.length;

        if (isPossible(arr1, arr2, n, k))
        {
            System.out.print("Yes");
        }
        else
        {
            System.out.print("No");
        }
    }
}
