
//Time Complexity: O(row×column)
//Space Complexity: O(n)

import java.util.Stack;

public class Q2_UsingStackSolve_Q1
{
    // Calculate the maximal rectangle area in a binary matrix
    public static int maximalRectangle(int[][] matrix)
    {
        if (matrix.length == 0) return 0;

        int maxArea = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];

        // Build histogram heights
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                heights[j] = matrix[i][j] == 1 ? heights[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, findMaxAreaInHistogram(heights));
        }
        return maxArea;
    }

    // Find maximum area in a histogram
    public static int findMaxAreaInHistogram(int[] heights)
    {
        int length = heights.length;
        int maxArea = 0;
        int[] left = new int[length];
        int[] right = new int[length];
        Stack<Integer> stack = new Stack<>();

        // 1 - Previous smaller elements
        for (int i = 0; i < length; i++)
        {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i])
            {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear(); // Clear stack

        // 2 - Next smaller elements
        for (int i = length - 1; i >= 0; i--)
        {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i])
            {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? length : stack.peek();
            stack.push(i);
        }

        // 3 - Calculate area
        for (int i = 0; i < length; i++)
        {
            int width = right[i] - left[i] - 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }

        return maxArea;
    }

    public static void main(String[] args)
    {
        int[][] matrix = {{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 1, 1, 1}};
        System.out.println("The maximum area is: " + maximalRectangle(matrix));
    }
}
