/*
Q5. Given two numbers represented by two lists, write a function that returns the sum list.
The sum list is a list representation of the addition of two input numbers.

Example:
Input:
List1: 5->6->3 // represents number 563
List2: 8->4->2 // represents number 842

Output:
Resultant list: 1->4->0->5 // represents number 1405
*/

public class Q5_SumLists {

    // Node class to represent each digit in the linked list
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // LinkedList class for handling basic operations
    public static class LinkedList_5 {
        Node head = null;
        Node tail = null;

        // Method to insert a new node at the end of the list
        void insertAtEnd(int data) {
            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
        }

        // Method to display the linked list
        void display() {
            Node temp = head;

            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }

        // Method to reverse the linked list
        Node reverse(Node head) {
            Node prev = null;
            Node current = head;
            Node next = null;

            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            return prev;
        }
    }

    // Method to add two numbers represented by linked lists and return the result as a linked list
    public static LinkedList_5 addTwoLists(Node l1, Node l2) {
        LinkedList_5 resultList = new LinkedList_5();
        int carry = 0;

        // Traverse both lists and add corresponding digits
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;  // Start with the carry from the previous operation

            if (l1 != null) {
                sum += l1.data; // Add digit from the first list
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.data; // Add digit from the second list
                l2 = l2.next;
            }

            carry = sum / 10; // Calculate carry for the next iteration
            int digit = sum % 10; // Current digit to be inserted into the result

            // Insert the digit into the result list
            resultList.insertAtEnd(digit);
        }

        return resultList; // Return the resultant list
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        // Creating two linked lists
        LinkedList_5 list1 = new LinkedList_5();
        list1.insertAtEnd(5);
        list1.insertAtEnd(6);
        list1.insertAtEnd(3); // Represents the number 563

        LinkedList_5 list2 = new LinkedList_5();
        list2.insertAtEnd(8);
        list2.insertAtEnd(4);
        list2.insertAtEnd(2); // Represents the number 842

        // Reverse the linked lists to get correct order
        Node reversedList1 = list1.reverse(list1.head);
        Node reversedList2 = list2.reverse(list2.head);

        // Adding two lists
        LinkedList_5 resultList = addTwoLists(reversedList1, reversedList2);

        // Reverse the result to get the final sum in the correct order
        resultList.head = resultList.reverse(resultList.head);

        // Displaying the result
        System.out.println("Resultant List:");
        resultList.display(); // Should display 1 -> 4 -> 0 -> 5 -> null (represents 1405)
    }
}
