/*
Q2. Implement a Map in java which takes the input and print the list in sorted order based on value.

Example :

Input: 5 - Rahul, 7 Lakshman, 1 Ram, 4 Krrish, 2 Lakshay

Output: {Krish=4,Lakshay=2,Lakshman=7,Rahul=5,Ram=1}

 */

// TC = O(n log n)
// SC = O(n)
import java.util.Scanner;
import java.util.TreeMap;

public class Q2_SortedOrderValue
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Approach - 1 - Using Loop
        TreeMap<String , Integer> tm1 = new TreeMap<>();
        System.out.println("Enter the size of List : ");
        int n = sc.nextInt();

        System.out.println("Enter the Key - value pairs : ");
        for(int i = 0; i < n; i++)
        {
            int key = sc.nextInt();
            String value = sc.next();

            tm1.put(value , key);
        }
        System.out.println(tm1);
    }
}
