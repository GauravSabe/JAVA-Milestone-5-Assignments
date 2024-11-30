/*

Q4. Given an array arr of size n, return the majority element.

Input: 4,2,7,1,9
Output: 9

*/

import java.util.HashMap;
import java.util.TreeMap;

public class Q4_MaxElement
{
    public static void main(String[] args)
    {
        int [] arr = {3, 1, 2, 8, 6};


        // Approach - 1
        // TC = O(n)
        // SC = O(n)
        HashMap<Integer , Integer> hm = new HashMap<>();

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++)
        {
            hm.put(i, arr[i]);
            if(hm.get(i) > max)
            {
                max = hm.get(i);
            }
        }
        System.out.println(max);

        // Approach - 2
        // TC = O(n log n)
        // SC = O(n)

        TreeMap<Integer , Integer> tm1 = new TreeMap<>();
        for (int j : arr)
        {
            tm1.put(j, 1);
        }
        System.out.println(tm1.lastEntry().getKey());


    }
}
