
/*
Pattern: Tree DFS
05 Count Paths for a Sum (medium)

Given a binary tree and a number ‘S’,
find all paths in the tree such that the sum of all the node values of each path equals ‘S’.
Please note that the paths can start or end at any node but all paths must follow direction from parent to child (top to bottom).
      1
    /  \
   7    9
 /  \  / \
 6  5 2  3

Sum = 12, Output = 3
3 paths with sum '12' : 7->5 , 1->9->2, 9->3

# LeetCode 437. Path Sum III
Runtime: 11 ms, faster than 46.58% of Java online submissions for Path Sum III.
Memory Usage: 40.4 MB, less than 69.31% of Java online submissions for Path Sum III.
*/

import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class CountAllPathSum {
  public static int countPaths(TreeNode root, int S) {
    if(root == null) return 0;
    return trackPaths(root, S, 0) + countPaths(root.left, S) + countPaths(root.right, S);
  }

  private static int trackPaths (TreeNode root, int sum, int currSum){
      if(root == null) return 0;

      currSum = currSum + root.val;
      if(currSum == sum){
        return 1+ trackPaths(root.left, sum, currSum) + trackPaths(root.right, sum, currSum);
      }
      return trackPaths(root.left, sum, currSum) + trackPaths(root.right, sum, currSum);
  }


  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
  }
}
