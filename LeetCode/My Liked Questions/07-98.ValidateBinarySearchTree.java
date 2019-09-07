/*
98. Validate Binary Search Tree
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
    public boolean isValidBST(TreeNode root){
        return dfsHelper(root, null, null);
    }

    private boolean dfsHelper(TreeNode root, TreeNode min, TreeNode max){
        if(root==null) return true;
        if(min!=null && root.val <= min.val || max!=null && root.val >= max.val) return false;

        return dfsHelper(root.left, min, root) && dfsHelper(root.right, root, max);
    }
}
