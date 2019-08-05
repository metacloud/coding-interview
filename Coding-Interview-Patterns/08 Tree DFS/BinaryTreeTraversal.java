/*
Binary Tree Traversal

94. Binary Tree Inorder Traversal
144. Binary Tree Preorder Traversal
145. Binary Tree Postorder Traversal

in-order: left - root - right
pre-order: root - left - right
post-order: left - right - root
*/

// Time & Space Complexity: O(N)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {        
        List<Integer> ret = new ArrayList<>();
        if(root==null) return ret;

        inorder(root, ret);
        return ret;   
    }
    
    public void inorder(TreeNode root, List<Integer> ret){
        if(root==null) return;
        //root.left
        inorder(root.left, ret);
        //root
        ret.add(root.val);
        //root.right
        inorder(root.right, ret);
    }
}


class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root==null) return ret;
        
        preorder(root, ret);
        return ret;
    }
    
    public void preorder(TreeNode root, List<Integer> ret){
        if(root==null) return;
        //root
        ret.add(root.val);  
        //root.left
        preorder(root.left, ret); 
        //root.right
        preorder(root.right, ret);
    }
}


class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root==null) return ret;
        
        postorder(root, ret);
        return ret;
    }
    
    public void postorder(TreeNode root, List<Integer> ret){
        if(root==null) return;
        //left
        postorder(root.left, ret);
        //right
        postorder(root.right, ret);    
        //root
        ret.add(root.val);
    }
}