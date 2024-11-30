import java.util.Stack;

public class Q9_UsingStackSolve_Q8
{
    public static void main(String[] args)
    {
        int [] asteroids = {5, 10, -5};
        Stack<Integer> s = new Stack<>();

        for(int elem : asteroids)
        {
            boolean isDestroyed = false;

            while (!s.isEmpty() && (elem < 0 && s.peek() > 0))
            {
                int top = s.pop();

                if(Math.abs(elem) == Math.abs(top))
                {
                    isDestroyed = true;
                    break;
                }
                else if (Math.abs(elem) > Math.abs(top))
                {
                    continue;
                }
                else
                {
                    s.push(top);
                    isDestroyed = true;
                    break;
                }
            }

            if(!isDestroyed)
            {
                s.push(elem);
            }
        }

        System.out.println(s);
    }
}
