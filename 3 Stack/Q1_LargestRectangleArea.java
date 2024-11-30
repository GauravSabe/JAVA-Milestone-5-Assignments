/*

Q1. Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing
only 1's and return its area.

Example 1:
Input: [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.

Example 2:
Input: matrix = [["0"]]
Output: 0

Example 3:
Input: matrix = [["1"]]
Output: 1

 */

//Time Complexity: O(row×column)
//Space Complexity: O(n)

public class Q1_LargestRectangleArea
{
    static int maxAreaOfRectangle(int [][] matrix)
    {
        if(matrix.length == 0)
        {
            return 0;
        }

        int row = matrix.length;
        int column = matrix[0].length;

        int [] Array1By1 = new int[column];

        int maxArea = 0;

        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < column; j++)
            {
                Array1By1[j] = matrix[i][j] == 1 ? Array1By1[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea , largestAreaRectangle(Array1By1));
        }
        return maxArea;
    }

    static int largestAreaRectangle(int [] heights)
    {
        int n = heights.length;

        // Empty array
        if(n == 0)
        {
            return 0;
        }

        // 1 - For Previous Smaller

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

        // 3 - Width and Area

        int maxArea = 0;

        for(int i = 0; i < n; i++)
        {
            int Width = nextSmaller[i] - previousSmaller[i] - 1;
            maxArea = Math.max(maxArea , heights[i] * Width);
        }

        return maxArea;
    }
    public static void main(String[] args)
    {

        int [][] matrix = {{0,1,1,0},{0,1,1,0},{0,1,1,1}};
        System.out.println("max area of rectangle : " + maxAreaOfRectangle(matrix));

    }
}
