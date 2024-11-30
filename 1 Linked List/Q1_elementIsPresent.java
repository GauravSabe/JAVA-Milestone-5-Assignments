/*

Q1. Given a linked list and a key 'X' in,
the task is to check if X is present in the linked list or not.

Examples:

    input : 14->21->11->30->10, X = 14
    output : Yes
    Explanation: 14 is present in the linked list.

    input : 6->21->17->30->10->8, X = 13
    output : No

*/

public class Q1_elementIsPresent
{
    public static class Node
    {
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
        }
    }

    public  static  class LinkedList_1
    {
        Node head = null;
        Node tail = null;

        void insertAtEnd(int data)
        {
            Node temp = new Node(data);

            if(head == null)
            {
                head = temp;
            }
            else
            {
                tail.next = temp;
            }
            tail = temp;
        }
    }

    public static boolean isPresent(int target)
    {
        LinkedList_1 ll1 = new LinkedList_1();

        ll1.insertAtEnd(1);
        ll1.insertAtEnd(2);
        ll1.insertAtEnd(3);
        ll1.insertAtEnd(4);
        ll1.insertAtEnd(5);

        Node temp = ll1.head;
        boolean flag = false;
        while(temp != null)
        {
            if(temp.data == target)
            {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        return  flag;
    }
    public static void main(String[] args)
    {
        int target = 6;
        System.out.println(isPresent(target));
    }
}
