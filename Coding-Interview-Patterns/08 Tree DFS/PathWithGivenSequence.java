
/*
Pattern: Tree DFS
04 Path With Given Sequence (medium)

Given a binary tree and a number sequence,
find if the sequence is present as a root-to-leaf path in the given tree.
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

class PathWithGivenSequence {
  public static boolean findPath(TreeNode root, int[] sequence){
    if(root==null) return sequence.length == 0;
    return recursivePath(root,0,sequence);
  }

  private static boolean recursivePath(TreeNode root, int level, int[] sequence){

    if(root==null) return false;
    if(level > sequence.length-1 || root.val != sequence[level]) return false;

    if(root.left == null && root.right == null && level == sequence.length-1){
      return true;
    }
    return recursivePath(root.left, level+1, sequence) || recursivePath(root.right, level+1, sequence);
  }/*
  Time Complexity: O(N) where N is the total number of nodes in the tree
  Space Complexity: O(N) ; recursion stack
  */

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(5);

    System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
    System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
  }
}
