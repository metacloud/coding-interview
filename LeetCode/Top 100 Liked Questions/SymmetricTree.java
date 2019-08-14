/*
LeetCode 101. Symmetric Tree

[Result]
Runtime: 0 ms, faster than 100.00% of Java online submissions for Symmetric Tree.
Memory Usage: 39.4 MB, less than 38.57% of Java online submissions for Symmetric Tree.
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
    public boolean isSymmetric(TreeNode root) {
        return recursiveCheck(root, root);
    }

    public boolean recursiveCheck(TreeNode r1, TreeNode r2){
        if(r1==null && r2==null) return true;
        if(r1==null || r2==null) return false;

        if(r1.val != r2.val) return false;
        return recursiveCheck(r1.left, r2.right) && recursiveCheck(r1.right, r2.left);
    }
}