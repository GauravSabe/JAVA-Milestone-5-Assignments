/*

Q5. Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using
the letters from magazine and false otherwise.
Each letter in magazine can only be used once in ransomNote.

Input: ransomNote = "a", magazine = "b"
Output: false

Input: ransomNote = "aa", magazine = "ab"
Output: false

*/

// TC = O(n + m)
// SC = O(n + m)
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q5_R_CU_M
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the RansomNote : ");
        String r = sc.next();

        System.out.println("Enter the Magazine : ");
        String m = sc.next();

        HashMap<Character , Integer> hm1 = new HashMap<>();

        for(int i = 0; i < r.length(); i++)
        {
            char ch = r.charAt(i);
            if(hm1.containsKey(ch))
            {
                hm1.put(ch , hm1.get(ch) + 1);
            }
            else
            {
                hm1.put(ch , 1);
            }
        }

        HashMap<Character , Integer> hm2 = new HashMap<>();

        for(int i = 0; i < m.length(); i++)
        {
            char ch = m.charAt(i);
            if(hm2.containsKey(ch))
            {
                hm2.put(ch , hm2.get(ch) + 1);
            }
            else
            {
                hm2.put(ch , 1);
            }
        }

        boolean ans = true;
        for(Map.Entry<Character , Integer> elem : hm1.entrySet())
        {
            if(!hm2.containsKey(elem.getKey()) || elem.getValue() > hm2.get(elem.getKey()))
            {
                ans = false;
                break;
            }
        }
        System.out.println(ans);
    }
}
