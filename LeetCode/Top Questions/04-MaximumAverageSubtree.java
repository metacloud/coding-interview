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
     double max = 0;
     public double maximumAverageSubtree(TreeNode root) {
         if(root==null) return 0;
         dfsHelper(root);
         return max;
     }

     public double[] dfsHelper(TreeNode root){ // {total, num_nodes}
         if(root==null) return new double[] {0,0};

         double total = root.val;
         int num_nodes = 1;

         double[] left = dfsHelper(root.left);
         double[] right = dfsHelper(root.right);

         total += left[0] + right[0];
         num_nodes += left[1] + right[1];
         double avg = total/num_nodes;
         max = Math.max(max, avg);

         return new double[] {total, num_nodes};
     }
 }/*
 Time Complexity: O(N)
 Space Complexity: O(N)
 */



 class Solution {
     private class Node {
         int total;
         int num_nodes;
         Node(int value, int num_nodes){
             this.total = value;
             this.num_nodes = num_nodes;
         }
     }

     double max=0;
     public double maximumAverageSubtree(TreeNode root) {
         if(root==null) return 0;
         dfsHelper(root);
         return max;
     }

     private Node dfsHelper(TreeNode root){
         if(root==null) return new Node(0,0);

         int total = root.val;
         int num_nodes = 1;

         Node left = dfsHelper(root.left);
         Node right = dfsHelper(root.right);

         total += left.total + right.total;
         num_nodes += left.num_nodes + right.num_nodes;

         double avg = (double)total/num_nodes;
         max = Math.max(max, avg);

         return new Node(total, num_nodes);
     }
 }
