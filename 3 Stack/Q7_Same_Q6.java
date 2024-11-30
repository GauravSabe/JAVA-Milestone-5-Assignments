import java.util.Stack;

public class Q7_Same_Q6
{
    public static void main(String[] args)
    {
        String [] arr = {"5","2","C","D","+"};

        int sum = 0;

        Stack<Integer> s = new Stack<>();

        for (String string : arr)
        {
            switch (string)
            {
                case "+" -> {
                    int temp1 = s.pop();
                    int temp2 = s.pop();
                    int tempSum = temp1 + temp2;

                    sum += tempSum;

                    s.push(temp2);
                    s.push(temp1);
                    s.push(tempSum);
                }
                case "D" -> {
                    int temp = s.pop();
                    int doubleElem = 2 * temp;

                    sum += doubleElem;

                    s.push(temp);
                    s.push(doubleElem);
                }
                case "C" -> {
                    int temp = s.pop();

                    sum -= temp;
                }
                default -> {
                    int temp = Integer.parseInt(string);

                    sum += temp;

                    s.push(temp);
                }
            }
        }

        System.out.println(sum);
    }
}
