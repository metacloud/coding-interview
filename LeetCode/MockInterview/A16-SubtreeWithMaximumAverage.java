/*
Subtree with Maximum Average
*/

/*
Given an N-ary tree, find the subtree with maximum average. Return the root of the subtree.
A subtree of a tree is any node of that tree plus all its descendants.
The average value of a subtree is the sum of its values, divided by the number of nodes.
*/

class Solution {
    double max = Integer.MIN_VALUE;
    TreeNode ret = null;
    public TreeNode maximumAverageSubtree(TreeNode root) {
        if(root==null) return ret;
        dfsHelper(root);
        return ret;
    }

    private double[] dfsHelper(TreeNode root){
        if(root==null) return new double[] {0,0};

        double total = root.val;
        int nodeCount = 1;
        for(TreeNode node : root.children){
            double[] ret = dfsHelper(node);
            total += ret[0];
            nodeCount += ret[1];
        }
        double avg = total/nodeCount;
        if(avg > max){
            max = avg;
            ret = root;
        }

        return new double[] {total, nodeCount};
    }
}/*
Time Complexity: O(N)
Space Complexity: O(N)
*/
