
/*
Pattern: Tree DFS
07 Path with Maximum Sum (hard)

Find the path with the maximum sum in a given a binary tree.
Write a function that returns the maximum sum.
A path can be defined as a sequence of nodes between any two leaf nodes and doesn’t necessarily pass through the root.

    1
  /  \
 2    3
 |   / \
 4  5  6

Output: 16
The path with max sum : [4, 2, 1, 3, 6]

# LeetCode 124. Binary Tree Maximum Path Sum [Hard]
Runtime: 1 ms, faster than 99.91% of Java online submissions for Binary Tree Maximum Path Sum.
Memory Usage: 40.8 MB, less than 85.50% of Java online submissions for Binary Tree Maximum Path Sum.
*/

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class MaximumPathSum {

  private static int maxSum;

  public static int findMaximumPathSum(TreeNode root) {
    maxSum = root.val;
    maxPathSum(root);
    return maxSum;
  }

  private static int maxPathSum(TreeNode root) {
    if(root==null) return 0;
    int leftSum = maxPathSum(root.left);
    int rightSum = maxPathSum(root.right);

    //since we have negative values,
    leftSum = Math.max(leftSum, 0);
    rightSum = Math.max(rightSum, 0);

    maxSum = Math.max( maxSum, root.val + leftSum + rightSum);

    return root.val + Math.max(leftSum, rightSum);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(6);
    root.right.left.left = new TreeNode(7);
    root.right.left.right = new TreeNode(8);
    root.right.right.left = new TreeNode(9);
    System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
    root = new TreeNode(-1);
    root.left = new TreeNode(-3);
    System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
  }
}
