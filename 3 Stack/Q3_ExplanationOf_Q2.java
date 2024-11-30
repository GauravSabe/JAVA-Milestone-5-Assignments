import java.util.Arrays;
import java.util.Stack;

public class Q3_ExplanationOf_Q2
{

    public static void main(String[] args)
    {
        int[] heights = {4, 2, 3, 4};
        int length = heights.length;
        int maxArea = 0;

        int[] left = new int[length];
        int[] right = new int[length];
        Stack<Integer> stack = new Stack<>();

        // 1 - Previous smaller
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i])
            {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        System.out.println("Previous Smaller : " + Arrays.toString(left));

        stack.clear(); // Clear stack for the next pass

        // 2 - Next smaller
        for (int i = length - 1; i >= 0; i--)
        {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i])
            {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? length : stack.peek();
            stack.push(i);
        }
        System.out.println("Next Smaller : " + Arrays.toString(right));

        // 3 - Width of rectangles
        int[] width = new int[length];
        for (int i = 0; i < length; i++)
        {
            width[i] = right[i] - left[i] - 1;
        }
        System.out.println("Widths of rectangles: " + Arrays.toString(width));

        // 4 - Area of rectangles
        int[] area = new int[length];
        for (int i = 0; i < length; i++)
        {
            area[i] = heights[i] * width[i];
        }
        System.out.println("Areas of rectangles: " + Arrays.toString(area));

        // 5 - Calculate max area
        for (int i = 0; i < length; i++)
        {
            maxArea = Math.max(maxArea, area[i]);
        }

        System.out.println("Maximum area of a rectangle present in Histogram is: " + maxArea);
    }
}
