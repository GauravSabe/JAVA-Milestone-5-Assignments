/*
Q2. Given an array of positive and negative integers, segregate them in linear time and constant
space. The output should print all negative numbers, followed by all positive numbers.

input : arr[] = {19, -20, 7, -4, -13, 11, -5, 3}
output : arr[] = {-20 ,-4, -13, -5, 19 ,11 ,3, 7}
 */

// TC = O(n)
// SC = O(1)
import java.util.Arrays;

public class Q2_PositiveNegative
{
    public static void main(String[] args)
    {
        int [] arr = {19, -20, 7, -4, -13, 11, -5, 3};

        int start = 0;
        int end = arr.length - 1;
        while (start < end)
        {
            if(arr[start] < 0 && arr[end] < 0)
            {
                start++;
            }
            else if (arr[start] > 0 && arr[end] > 0)
            {
                end--;
            }
            else if (arr[start] > 0 && arr[end] < 0)
            {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;

                start++;
                end--;
            }
            else
            {
                start++;
                end--;
            }
        }
        System.out.println(Arrays.toString(arr));

    }
}
