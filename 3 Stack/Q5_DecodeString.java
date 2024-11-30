/*
Q2. Given an encoded string, return its decoded string. The encoding rule is: k[encoded_string],
where the encoded_string inside the square brackets is being repeated exactly k times. Note
that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; there are no extra white spaces, square
brackets are well-formed, etc. Furthermore, you may assume that the original data does not
contain any digits and that digits are only for those repeat numbers, k. For example, there will
not be input like 3a or 2[4].

Example 1:
input : s = "3[a]2[bc]"
output : "aaabcbc"

 */


//Time Complexity: O(n + m)
//Space Complexity: O(m + d)
//where n is the length of the input string.
//where m is the length of the decoded string.
//where d is the maximum depth of nested brackets.
import java.util.Scanner;
import java.util.Stack;

public class Q5_DecodeString
{
    static String decodeString(String input)
    {
        StringBuilder currentString = new StringBuilder();

        Stack<Integer> count = new Stack<>();
        Stack<StringBuilder> result = new Stack<>();

        int k = 0;

        char [] ch = input.toCharArray();

        for(char elem : ch)
        {
            if(Character.isDigit(elem))
            {
                k = k * 10 + (elem - '0');
            }
            else if (elem == '[')
            {
                count.push(k);
                result.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            }
            else if (elem == ']')
            {
                StringBuilder temp = currentString;
                currentString = result.pop();
                int repeatedTimes = count.pop();
                while (repeatedTimes-- > 0)
                {
                    currentString.append(temp);
                }
            }
            else
            {
                currentString.append(elem);
            }
        }
        return currentString.toString();
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Encoded String : ");
        String str = sc.next();

        System.out.println("Decoded String is : " + decodeString(str));


    }
}
