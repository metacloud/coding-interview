/*
LeetCode 617. Merge Two Binary Trees

[Result]
Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Binary Trees.
Memory Usage: 40 MB, less than 100.00% of Java online submissions for Merge Two Binary Trees.
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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t2==null) return t1;
        if(t1==null && t2!= null) return t2;
        
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        t1.val = t1.val + t2.val;
        
        return t1; 
    }/*
	Time Complexity: O(N)
	Space Complexity:  O(N)
    */
}