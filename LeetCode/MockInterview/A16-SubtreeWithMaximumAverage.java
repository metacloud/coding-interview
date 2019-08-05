/*
1120. Maximum Average Subtree
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
    private class node {
        int numNodes;
        int sum; 
        node(int numNodes, int sum){
            this.numNodes = numNodes;
            this.sum = sum;
        }
    }
    
    double max = 0.0;
    public double maximumAverageSubtree(TreeNode root) { 
        getMaxAvg(root);        
        return max;
    }
    
    private node getMaxAvg(TreeNode root){
        if(root==null) return new node(0,0);
        
        node left = getMaxAvg(root.left);
        node right = getMaxAvg(root.right);
        int numNodes = left.numNodes + right.numNodes + 1;
        int totalSum = left.sum + right.sum + root.val;
        
        max = Math.max(max, (double)totalSum/numNodes);
        
        return new node(numNodes, totalSum);   
    }  
}