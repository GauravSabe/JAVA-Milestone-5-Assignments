/*

**Q3. Baseball Game Scoring**

You are keeping the scores for a baseball game with strange rules.
At the beginning of the game, you start with an empty record.
You are given a list of strings `operations`,
where `operations[i]` is the i -th operation you must apply to the record,
and it can be one of the following:

1. An integer `x`: Record a new score of `x`.
2. `'+'`: Record a new score that is the sum of the previous two scores.
3. `'D'`: Record a new score that is double the previous score.
4. `'C'`: Invalidate the previous score, removing it from the record.

Return the sum of all scores on the record after applying all the operations.

### Examples :

**Example 1**
Input: `ops = ["5","2","C","D","+"]`
Output: `30`
Explanation:
- `"5"` - Add `5` to the record, record is now `[5]`.
- `"2"` - Add `2` to the record, record is now `[5, 2]`.
- `"C"` - Invalidate and remove the previous score, record is now `[5]`.
- `"D"` - Add `2 * 5 = 10` to the record, record is now `[5, 10]`.
- `"+"` - Add `5 + 10 = 15` to the record, record is now `[5, 10, 15]`.

The total sum is `5 + 10 + 15 = 30`.

**Example 2**
Input: `ops = ["5","-2","4","C","D","9","+","+"]`
Output: `27`
Explanation:
- `"5"` - Add `5` to the record, record is now `[5]`.
- `"-2"` - Add `-2` to the record, record is now `[5, -2]`.
- `"4"` - Add `4` to the record, record is now `[5, -2, 4]`.
- `"C"` - Invalidate and remove the previous score, record is now `[5, -2]`.
- `"D"` - Add `2 * -2 = -4` to the record, record is now `[5, -2, -4]`.
- `"9"` - Add `9` to the record, record is now `[5, -2, -4, 9]`.
- `"+"` - Add `-4 + 9 = 5` to the record, record is now `[5, -2, -4, 9, 5]`.
- `"+"` - Add `9 + 5 = 14` to the record, record is now `[5, -2, -4, 9, 5, 14]`.

The total sum is `5 + -2 + -4 + 9 + 5 + 14 = 27`.

**Example 3**
Input: `ops = ["1","C"]`
Output: `0`
Explanation:
- `"1"` - Add `1` to the record, record is now `[1]`.
- `"C"` - Invalidate and remove the previous score, record is now `[]`.

 */

//Time Complexity: O(n)
//Space Complexity: O(n)

import java.util.Stack;

public class Q6_BaseballGame
{
    public static void main(String[] args)
    {
        String [] arr = {"5","2","C","D","+"};

        int sum = 0;

        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i].equals("+"))
            {
                int temp1 = s.pop();
                int temp2 = s.pop();
                int tempSum = temp1 + temp2;

                sum += tempSum;

                s.push(temp2);
                s.push(temp1);
                s.push(tempSum);
            }
            else if (arr[i].equals("D"))
            {
                int temp = s.pop();
                int doubleElem = 2 * temp;

                sum += doubleElem;

                s.push(temp);
                s.push(doubleElem);
            }
            else if(arr[i].equals("C"))
            {
                int temp = s.pop();

                sum -= temp;
            }
            else
            {
                int temp = Integer.parseInt(arr[i]);

                sum += temp;

                s.push(temp);
            }
        }

        System.out.println(sum);
    }
}
