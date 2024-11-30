import java.util.Arrays;

// TC = O(n)
// SC = O(1)
public class Q3_Solve_Q2
{
    public static void main(String[] args)
    {
        int [] arr = {19, -20, 7, -4, -13, 11, -5, 3};
        int left = 0;
        int right = arr.length - 1;

        int pivot = left;

        for(int j = left + 1; j <= right; j++)
        {
            if(arr[j] <= 0)
            {
                int temp = arr[j];
                arr[j] = arr[pivot];
                arr[pivot] = temp;

                pivot++;
            }
        }

        System.out.println(Arrays.toString(arr));

    }
}
