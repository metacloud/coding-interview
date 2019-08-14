/*
654. Maximum Binary Tree

Except it was to find the maximum average node excluding the last leaf node of a N-ary tree.
*/

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums){
        TreeNode root = null;
        for(int i=0; i<nums.length; i++){
            root = buildTree(root, nums[i]);
        }
        return root;
    }

    private TreeNode buildTree(TreeNode node, int value){
        if(node==null) return new TreeNode(value);

        if(value < node.val) {
            //we need to add this to right
            node.right = add(node.right, value);
            return node;
        }

        else { // value>node.val
            TreeNode newNode = new TreeNode(value);
            newNode.left = node;
            return newNode;
        }
    }
}/*
Time complexity : O(N^2)
Space complexity : O(N)
*/
