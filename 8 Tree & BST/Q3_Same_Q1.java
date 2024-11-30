// CG

// TC : O(n)
// SC : O(w)  --> where w is maximum width
import java.util.*;

class Q3_Same_Q1
{
    public static class Node
    {
        int key;
        Node left = null, right = null;

        Node(int data)
        {
            this.key = data;
        }
    }
    public static void spiralOrderTraversal(Node root)
    {
        if (root == null)
        {
            return;
        }

        // Initialize a deque (double-ended queue) to process levels
        Deque<Node> deque = new LinkedList<>();
        deque.add(root);

        // Flag to toggle between left-to-right and right-to-left
        boolean leftToRight = true;

        while (!deque.isEmpty())
        {
            int levelSize = deque.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++)
            {
                if (leftToRight)
                {
                    // Remove from front for left-to-right traversal
                    Node node = deque.pollFirst();
                    currentLevel.add(node.key);

                    // Add children from left to right
                    if (node.left != null)
                    {
                        deque.addLast(node.left);
                    }
                    if (node.right != null)
                    {
                        deque.addLast(node.right);
                    }
                }
                else
                {
                    // Remove from back for right-to-left traversal
                    Node node = deque.pollLast();
                    currentLevel.add(node.key);

                    // Add children from right to left
                    if (node.right != null)
                    {
                        deque.addFirst(node.right);
                    }
                    if (node.left != null)
                    {
                        deque.addFirst(node.left);
                    }
                }
            }

            // Print the current level
            System.out.println(currentLevel);

            // Toggle the direction for the next level
            leftToRight = !leftToRight;
        }
    }

    public static void main(String[] args)
    {
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);

        System.out.println("Spiral Order Traversal:");
        spiralOrderTraversal(root);
    }
}
