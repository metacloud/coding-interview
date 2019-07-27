/*
226. Invert Binary Tree

[Result]
Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
Memory Usage: 34.2 MB, less than 100.00% of Java online submissions for Invert Binary Tree.
*/

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }/*
    Time Complexity: O(N)
    Space Complexity: O(N) (O(h) where h is the height of the tree)
    */
}
