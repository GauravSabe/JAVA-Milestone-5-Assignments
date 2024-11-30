/*
Q1. Implement a Map in java which takes the input and print the list in sorted order based on key.

Example :

Input: 5- Rahul, 7 Lakshman, 1 Ram, 4 Krrish, 2 Lakshay

Output: { 1=Ram, 2=Lakshay, 4=Krrish, 5=Rahul, 7=lakshman }

 */

// TC = O(n log n)
// SC = O(n)
import java.util.Scanner;
import java.util.TreeMap;

public class Q1_SortedOrderKey
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Approach - 1 - Manually
        TreeMap<Integer , String> tm = new TreeMap<>();

        tm.put(5 , "Rahul");
        tm.put(7 , "Lakshman");
        tm.put(1 , "Ram");
        tm.put(4 , "Krrish");
        tm.put(2 , "Lakshya");

        System.out.println(tm);

        // Approach - 2 - Using Loop
        TreeMap<Integer , String> tm1 = new TreeMap<>();
        System.out.println("Enter the size of List : ");
        int n = sc.nextInt();

        System.out.println("Enter the Key - value pairs : ");
        for(int i = 0; i < n; i++)
        {
            int key = sc.nextInt();
            String value = sc.next();

            tm1.put(key , value);
        }
        System.out.println(tm1);

    }
}
