/*
653. Two Sum IV - Input is a BST
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
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;

        Set<Integer> set = new HashSet<>();
        return dfsHelper(root, k, set);
    }

    public boolean dfsHelper(TreeNode root, int k, Set<Integer> set){
        if(root==null) return false;

        if(set.contains(k-root.val)) return true;
        set.add(root.val);

        return dfsHelper(root.left, k, set) || dfsHelper(root.right, k, set);
    }
} /*
Time Complexity: O(N)
Space Complexity: O(N). The size of the set can be upto N in the worst case.
*/
