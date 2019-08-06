/*
230. Kth Smallest Element in a BST
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
    int count, value;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return 0;
        this.count = k;
        dfs(root);
        return value;

    }

    public boolean dfs(TreeNode root){ //minimize time complexity
        if(root==null) return false;

        //left
        boolean isTrue = dfs(root.left);
        if(isTrue) return true;
        //root
        if(--count==0){
            value = root.val;
            return true;
        }
        //right
        return dfs(root.right);
    }
}/*
Time complexity: O(N)
Space complexity: O(N)
*/
