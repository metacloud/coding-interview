/*
538. Convert BST to Greater Tree
*/


// Recursion
class Solution {
    private int finalVal = 0;
    public TreeNode convertBST(TreeNode root){
        if(root != null) {
            convertBST(root.right);
            finalVal = finalVal + root.val;
            root.val = finalVal;
            convertBST(root.left);
        }
        return root;
    }
}
