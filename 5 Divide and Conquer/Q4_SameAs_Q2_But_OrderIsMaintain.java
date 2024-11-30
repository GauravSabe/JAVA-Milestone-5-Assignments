/*

Q3. Given an array of positive and negative integers, segregate them in linear time and constant
space. The output should print all negative numbers, followed by all positive numbers. The
relative order of elements must remain the same.

input : arr[] = {19, -20, 7, -4, -13, 11, -5, 3}
output : arr[] = {-20 ,-4, -13, -5, 19 ,7 ,11, 3}

 */

// TC = O(n log n)
// SC = O(n)
import java.util.Arrays;

public class Q4_SameAs_Q2_But_OrderIsMaintain
{
    public static void partition(int [] arr , int [] temp , int left , int right)
    {
        if(right <= left)
        {
            return;
        }

        // Divide
        int mid = left + (right - left) / 2;

        // Conquer
        // left sub array
        partition(arr , temp , left , mid);
        // right sub array
        partition(arr , temp , mid + 1 , right);

        //combine
        marge(arr , temp , left , mid , right);
    }

    public static void marge(int [] arr , int [] temp , int left , int mid , int right)
    {
        int k = left;

        // 1.copy negative elements from the left sub-array
        for(int i = left; i <= mid; i++)
        {
            if(arr[i] < 0)
            {
                temp[k] = arr[i];
                k = k + 1;
            }
        }

        // 2.copy negative elements from the right sub-array
        for(int j = mid + 1; j < right; j++)
        {
            if(arr[j] < 0)
            {
                temp[k] = arr[j];
                k = k + 1;
            }
        }

        // 3.copy positive elements from the left sub-array
        for(int i = left; i <= mid; i++)
        {
            if(arr[i] >= 0)
            {
                temp[k] = arr[i];
                k = k + 1;
            }
        }

        // 4.copy positive elements from the right sub-array
        for(int j = mid + 1; j < right; j++)
        {
            if(arr[j] >= 0)
            {
                temp[k] = arr[j];
                k = k + 1;
            }
        }

        // 5.copy back to the original array to reflect the relative order
        for(int i = left; i < right; i++)
        {
            arr[i] = temp[i];
        }
    }

    public static void main(String[] args)
    {
        int [] arr = {19, -20, 7, -4, -13, 11, -5, 3};

        int n = arr.length;

        int [] temp = new int[n];

        for (int i = 0; i < arr.length; i++)
        {
            temp[i] = arr[i];
        }

        partition(arr , temp , 0 , n - 1);

        System.out.println(Arrays.toString(arr));

    }
}
