/*
LeetCode 437. Path Sum III

[Result]
Runtime: 10 ms, faster than 70.46% of Java online submissions for Path Sum III.
Memory Usage: 40.4 MB, less than 71.44% of Java online submissions for Path Sum III.
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
    public int pathSum(TreeNode root, int sum) {
        if(root==null) return 0;
        return pathSum(root.left, sum) + pathSum(root.right, sum) + recursiveDFS(root, sum);
    }
    
    public int recursiveDFS(TreeNode root, int sum){
        if(root==null) return 0; 
        if(root.val == sum) {
            return 1 + recursiveDFS(root.left, sum-root.val) + recursiveDFS(root.right, sum-root.val);
        }
        return recursiveDFS(root.left, sum-root.val) + recursiveDFS(root.right, sum-root.val);
    }
}/*
Time Complexity: worst = O(N^2) for skewed tree, best = O(NlogN) for balanced tree
Space Complexity: O(N)
*/
