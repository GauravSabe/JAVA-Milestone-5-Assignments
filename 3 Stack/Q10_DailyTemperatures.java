/*
**Q5. Daily Temperatures Problem**

You are given an array of integers, `temperatures`, representing the daily temperatures.
The goal is to return an array, `answer`, where each `answer[i]` is the number of days you would have
to wait after the `i-th` day to encounter a warmer temperature.
If there is no future day with a warmer temperature, set `answer[i] = 0`.

### Example

**Example 1:**
- Input: `temperatures = [73,74,75,71,69,72,76,73]`
- Output: `[1,1,4,2,1,1,0,0]`

  **Explanation:**
  - Day 0: Wait 1 day for a warmer temperature of 74.
  - Day 1: Wait 1 day for a warmer temperature of 75.
  - Day 2: Wait 4 days for a warmer temperature of 76.
  - Day 3: Wait 2 days for a warmer temperature of 72.
  - Day 4: Wait 1 day for a warmer temperature of 72.
  - Day 5: Wait 1 day for a warmer temperature of 76.
  - Day 6: No future day is warmer, so answer is 0.
  - Day 7: No future day is warmer, so answer is 0.

**Example 2:**
- Input: `temperatures = [30,40,50,60]`
- Output: `[1,1,1,0]`

  **Explanation:**
  - Each day has a warmer temperature the next day, except the last one.

**Example 3:**
- Input: `temperatures = [30,60,90]`
- Output: `[1,1,0]`

  **Explanation:**
  - Day 0: Wait 1 day for a warmer temperature of 60.
  - Day 1: Wait 1 day for a warmer temperature of 90.
  - Day 2: No future day is warmer, so answer is 0.

### Constraints
- `1 <= temperatures.length <= 10^5`
- `30 <= temperatures[i] <= 100`

 */

//Time Complexity: O(n)
//Space Complexity: O(n)

import java.util.Arrays;
import java.util.Stack;

public class Q10_DailyTemperatures
{
    public static void main(String[] args)
    {
        int [] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

        int n = temperatures.length;

        int [] ans = new int[n];

        Stack<Integer> s = new Stack<>();

        for (int i = n-1; i >= 0; i--)
        {
            while (!s.isEmpty() && temperatures[i] >= temperatures[s.peek()])
            {
                s.pop();
            }

            if(!s.isEmpty())
            {
                ans[i] = s.peek() - i;
            }
            else
            {
                ans[i] = 0;
            }
            s.push(i);
        }
        System.out.println(Arrays.toString(ans));

    }
}
