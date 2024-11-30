/*

Q3. Given the head of a sorted linked list, delete all duplicates such that each element
appears only once. Return the linked list sorted as well.

Example 1:
Input: head = [1,1,2]
Output: [1,2]


Example 2:
Input: head = [1,1,2,3,3]
Output: [1,2,3]

*/
public class Q3_SortedDeleteAllDuplicates
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

    public static class LinkedList_3
    {
        Node head = null;
        Node tail = null;

        void insertAtEnd(int data)
        {
           Node temp = new Node(data);

            if (head == null)
            {
                head = temp;
            }
            else
            {
                tail.next = temp;
            }
            tail = temp;
        }
        void display()
        {
            Node temp = head;

            while (temp != null)  // Traverse through the list
            {
                System.out.print(temp.data + " ");  // Print each node's data
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void DeleteAllDuplicates(Node temp)
    {
        while (temp != null && temp.next != null)
        {
            if(temp.data == temp.next.data)
            {
                temp.next = temp.next.next;
            }
            else
            {
                temp = temp.next;
            }
        }
    }
    public static void main(String[] args)
    {
        LinkedList_3 ll3 = new LinkedList_3();

        ll3.insertAtEnd(1);
        ll3.insertAtEnd(1);
        ll3.insertAtEnd(2);
        ll3.insertAtEnd(3);
        ll3.insertAtEnd(3);
        ll3.insertAtEnd(5);

        ll3.display();
        DeleteAllDuplicates(ll3.head);
        ll3.display();
    }
}
