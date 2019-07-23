/*
LeetCode 543. Diameter of Binary Tree

[Result]
Runtime: 0 ms, faster than 100.00% of Java online submissions for Diameter of Binary Tree.
Memory Usage: 38.5 MB, less than 35.92% of Java online submissions for Diameter of Binary Tree.
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
	int longestPath = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        getLongestPath(root);
        return longestPath;
    }
    
    public int getLongestPath(TreeNode root){
        if(root==null) return 0;
        int left = getLongestPath(root.left);
        int right = getLongestPath(root.right);
        longestPath = Math.max(longestPath, left+right);
        return  1 + Math.max(left,right);
    }
}/*
Time Complexity: O(N)
Space Complexity: O(N)
*/