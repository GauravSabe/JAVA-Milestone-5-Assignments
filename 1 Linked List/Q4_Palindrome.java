/*

Q4. Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

Example 1:
input : head = [1,2,2,1]
output : true

Example 2:
input : head = [1,2]
output : false

*/

public class Q4_Palindrome
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

    public static class LinkedList_4
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

    // Method to reverse a linked list and return the new head
    public static Node reverseList(Node slow)
    {
        Node curr = slow;
        Node prev = null;
        Node next = null;

        while (curr != null)
        {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev; // New head of the reversed list
    }

    // Method to check if a linked list is a palindrome
    public static boolean isPalindrome(Node head)
    {
        if (head == null || head.next == null) {
            return true; // Empty or single node list is always a palindrome
        }

        Node slow = head;
        Node fast = head;

        // Find the middle of the list using the slow and fast pointer approach
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the list
        Node secondHalfHead = reverseList(slow);

        // Compare the first half and the reversed second half
        Node p1 = head;
        Node p2 = secondHalfHead;

        while (p2 != null)
        {
            if (p1.data != p2.data) {
                return false; // Not a palindrome if mismatch
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // (Optional) Reverse the second half back to restore the original list
        reverseList(secondHalfHead);

        return true; // The linked list is a palindrome
    }

    public static void main(String[] args)
    {
        LinkedList_4 ll4 = new LinkedList_4();

        ll4.insertAtEnd(1);
        ll4.insertAtEnd(2);
        ll4.insertAtEnd(1);

        System.out.println(isPalindrome(ll4.head));
    }
}
