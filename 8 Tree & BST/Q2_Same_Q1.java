// YT

// TC : O(n)
// SC : O(w)  --> where w is maximum width

import java.util.*;
public class Q2_Same_Q1
{
    public static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val)
        {
            this.val = val;
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root)
    {
        List<List<Integer>> zigzag = new ArrayList<>();
        if (root == null)
        {
            return zigzag;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;

        while (!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            Stack<Integer> reverseStack = new Stack<>();

            for (int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                if (flag)
                {
                    reverseStack.add(node.val);
                }
                else
                {
                    level.add(node.val);
                }

                if (node.left != null)
                {
                    queue.add(node.left);
                }
                if (node.right != null)
                {
                    queue.add(node.right);
                }
            }

            flag = !flag;
            while (!reverseStack.isEmpty())
                level.add(reverseStack.pop());

            zigzag.add(level);
        }

        return zigzag;
    }

    public static void main(String[] args)
    {
        // Create a sample binary tree
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(12);
        root.right.left = new TreeNode(16);
        root.right.right = new TreeNode(25);

        // Call the static zigzagLevelOrder method directly
        List<List<Integer>> result = zigzagLevelOrder(root);

        // Print the result
        System.out.println(result);
    }
}
