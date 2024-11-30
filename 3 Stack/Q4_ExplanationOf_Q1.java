import java.util.Arrays;

public class Q4_ExplanationOf_Q1
{
    public static void main(String[] args)
    {
        int [] heights = {4 , 2 , 1 , 5 , 6 , 3 , 2 , 4 , 2};
        int n = heights.length;

        // Empty array
        if(n == 0)
        {
            System.out.println("Array is empty");
        }

        // 1 - For previousSmaller

        int [] previousSmaller = new int[n];
        previousSmaller[0] = -1;

        for(int i = 1; i < n; i++)
        {
            int previous = i - 1;
            while (previous >= 0 && heights[previous] >= heights[i])
            {
                previous = previousSmaller[previous];
            }
            previousSmaller[i] = previous;
        }
        System.out.println(Arrays.toString(previousSmaller));

        // 2 - For Next Smaller

        int [] nextSmaller = new int[n];
        nextSmaller[n-1] = n;

        for(int i = n - 2; i >= 0; i--)
        {
            int next = i + 1;
            while (next < n && heights[next] >= heights[i])
            {
                next = nextSmaller[next];
            }
            nextSmaller[i] = next;
        }
        System.out.println(Arrays.toString(nextSmaller));

        // 3 - Width of a Rectangle

        int [] Width = new int[n];

        for(int i = 0; i < n; i++)
        {
            Width[i] = nextSmaller[i] - previousSmaller[i] - 1;
        }
        System.out.println(Arrays.toString(Width));

        // 4 - Area of a Rectangle

        int [] Area = new int[n];

        for(int i = 0; i < n; i++)
        {
            Area[i] = heights[i] * Width[i];
        }
        System.out.println(Arrays.toString(Area));

        // 5 - Max Area of a Rectangle
        int maxArea = 0;
        for(int i = 0; i < n; i++)
        {
            maxArea = Math.max(maxArea , Area[i]);
        }
        System.out.println("Maximum area of an rectangle present in Histogram is : " + maxArea);

    }
}

