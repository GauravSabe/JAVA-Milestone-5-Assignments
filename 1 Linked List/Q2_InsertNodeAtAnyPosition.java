/*

Q2. Insert a node at the given position in a linked list. We are given a pointer to a node, and the
new node is inserted after the given node.


input : LL = 1 -> 2 -> 4 -> 5 -> 6 pointer = 2 value = 3.
output : 1 -> 2 -> 3 -> 4 -> 5 -> 6

 */
public class Q2_InsertNodeAtAnyPosition
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

    public static class LinkedList_2
    {
        Node head = null;
        Node tail = null;

        void insertAtEnd(int data) {
            Node temp = new Node(data);

            if (head == null) {
                head = temp;
            } else {
                tail.next = temp;
            }
            tail = temp;
        }

        void display() {
            Node temp = head;

            while (temp != null)  // Traverse through the list
            {
                System.out.print(temp.data + " ");  // Print each node's data
                temp = temp.next;
            }
            System.out.println();
        }
    }
    public static void insertAtAnyPointer(int idx, int data)
    {
        LinkedList_2 ll2 = new LinkedList_2();

        ll2.insertAtEnd(1);
        ll2.insertAtEnd(2);
        ll2.insertAtEnd(4);
        ll2.insertAtEnd(5);
        ll2.insertAtEnd(6);

        Node t = new Node(data);
        Node temp = ll2.head;
        if(idx < 1)
        {
            System.out.println("Invalid input please select the index >= 1");
            return;
        }
        else
        {
            for(int i = 0; i < idx - 1; i++)
            {
                temp = temp.next;
            }
            t.next = temp.next;
            temp.next = t;
        }
        ll2.display();
    }
    public static void main(String[] args)
    {
        insertAtAnyPointer(1 , 3);
    }
}
