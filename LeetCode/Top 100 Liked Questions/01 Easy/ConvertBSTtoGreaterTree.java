/*
538. Convert BST to Greater Tree

[Result]
Runtime: 1 ms, faster than 74.15% of Java online submissions for Convert BST to Greater Tree.
Memory Usage: 42.1 MB, less than 33.64% of Java online submissions for Convert BST to Greater Tree.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null) return null;
        convertBST(root.right);
        sum = sum + root.val;
        root.val = sum;
        convertBST(root.left);

        return root;
    }
}
