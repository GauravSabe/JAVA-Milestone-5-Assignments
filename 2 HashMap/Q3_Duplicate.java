/*
Q3.Detect if an Array contains a duplicate element. At Most 1 duplicate would be there.

Input: 1,2,3,4
Output: No

Input: 1, 2, 3, 4, 1
Output: Yes.
 */

import java.util.HashMap;
import java.util.TreeMap;

public class Q3_Duplicate
{
    public static void main(String[] args)
    {
        int [] arr = {1, 2, 3, 4};

        // Approach - 1
        // TC = O(n log n)
        // SC = O(n)
        TreeMap<Integer , Integer> tm = new TreeMap<>();

        for (int k : arr)
        {
            if (tm.containsKey(k))
                tm.put(k, tm.get(k) + 1);
            else
                tm.put(k, 1);
        }

        boolean flag = false;
        for (int j : arr)
        {
            if (tm.get(j) != 1)
            {
                flag = true;
                break;
            }
        }

        if(!flag)
        {
            System.out.println("No");
        }
        else
        {
            System.out.println("Yes");
        }

        int [] arr1 = {1, 2, 3, 4};


        // Approach - 2
        // TC = O(n)
        // SC = O(n)
        HashMap<Integer , Integer> hm = new HashMap<>();
        boolean flag1 = false;
        for (int k : arr1)
        {
            if (hm.containsKey(k))
            {
                hm.put(k, hm.get(k) + 1);
                flag1 = true;
                System.out.println("Yes");
            }
            else
                hm.put(k, 1);
        }
        if(!flag1)
        {
            System.out.println("No");
        }


    }
}
