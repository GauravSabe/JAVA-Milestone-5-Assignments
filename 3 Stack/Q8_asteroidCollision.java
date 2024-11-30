/*
**Q4. Asteroid Collision Problem**

You are given an array of integers, `asteroids`, where each integer represents an asteroid in a row.
The absolute value of each integer represents the size of the asteroid,
and the sign represents its direction:
- A positive value indicates the asteroid is moving to the right.
- A negative value indicates the asteroid is moving to the left.

Each asteroid moves at the same speed. When two asteroids collide:
- The smaller asteroid explodes.
- If both asteroids have the same size, both explode.
- Two asteroids moving in the same direction will never collide.

Write a function to determine the state of the asteroids after all collisions.

### Examples:

**Example 1:**

Input: asteroids = [5, 10, -5]
Output: [5, 10]
Explanation: The asteroid with size 10 and -5 collide, resulting in 10. The asteroids 5 and 10 never collide.


**Example 2:**

Input: asteroids = [8, -8]
Output: []
Explanation: The asteroids with sizes 8 and -8 collide and both explode, leaving no asteroids.


**Example 3:**

Input: asteroids = [10, 2, -5]
Output: [10]
Explanation: The asteroids 2 and -5 collide, resulting in -5. Then, the asteroids 10 and -5 collide, resulting in 10.

 */

import java.util.ArrayList;
import java.util.List;

public class Q8_asteroidCollision
{
    public static void main(String[] args)
    {
        int [] arr = {5,10,-5};
        List<Integer> l = new ArrayList<>();

        l.add(arr[0]);

        for(int i = 1; i < arr.length; i++)
        {
            l.add(arr[i]);

            int j = l.size() - 1;

            // Conditions for Collisions

            while (j > 0 && (l.get(j) < 0 && l.get(j - 1) >= 0))
            {
                int first = l.remove((l.size() - 1));
                int second = l.remove((l.size() - 1));

                //If both have same value then both will destroy
                if(Math.abs(first) == Math.abs(second))
                {
                    j = j - 2;
                    continue;
                }
                else if (Math.abs(first) > Math.abs(second)) //If first have greater value then 2nd will destroy
                {
                    j--;
                    l.add(first);
                }
                else  //If 2nd have greater value then 1st will destroy
                {
                    j--;
                    l.add(second);
                }
            }
        }
        System.out.println(l);
    }
}
