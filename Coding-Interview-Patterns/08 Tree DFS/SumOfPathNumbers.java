
/*
Pattern: Tree DFS
03 Sum of Path Numbers (medium)

Given a binary tree where each node can only have a digit (0-9) value,
each root-to-leaf path will represent a number.
Find the total sum of all the numbers represented by all paths.

Path                    Number
6->3->2                   632
6->3->5->7               6357
6->3->5->4               6354
6->5>4                    654
Answer = 632 + 6357 + 6354 + 654 = 13997
*/

import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int val){
    this.val = val;
  }
};

class SumOfPathNumbers {
  public static int findSumOfPathNumbers(TreeNode root){
    if(root==null) return 0;
    List<Integer> totalPathSum = new ArrayList<>();
    recursivePath(root, 0, totalPathSum);

    int totalSum = 0;
    for(int pathSum : totalPathSum){
      totalSum += pathSum;
    }

    return totalSum;
  }

  private static void recursivePath(TreeNode root, int PathSum, List<Integer> totalPathSum){
    if(root==null) return;

    PathSum = 10*PathSum + root.val;
    if(root.left==null && root.right==null){//this.root == leaf node
      totalPathSum.add(PathSum);
    }
    else {
      recursivePath(root.left, PathSum, totalPathSum);
      recursivePath(root.right, PathSum, totalPathSum);
    }
  }/*
  Time Complexity: O(N)
  Space Complexity: O(N)
  */

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(5);
    System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
  }
}
