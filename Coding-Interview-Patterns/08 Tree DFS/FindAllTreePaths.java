
/*
Pattern: Tree DFS
02 All Paths for a Sum (medium)

Given a binary tree and a number ‘S’,
find all paths from root-to-leaf such that the sum of all the node values of each path equals ‘S’.

# LeetCode 113. Path Sum II [Medium]
[Result]
Runtime: 1 ms, faster than 99.96% of Java online submissions for Path Sum II.
Memory Usage: 37.8 MB, less than 99.96% of Java online submissions for Path Sum II.
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

class FindAllTreePaths {
  public static List<List<Integer>> findPaths(TreeNode root, int sum) {
      List<List<Integer>> allPaths = new ArrayList<>();
      List<Integer> currentPath = new ArrayList<>();
      if(root==null) return allPaths;
      recursiveTraversal(root, allPaths, currentPath, sum);
      return allPaths;
  }

  private static void recursiveTraversal(TreeNode root, List<List<Integer>> allPaths, List<Integer> currentPath, int sum){

      if(root==null) return;
      currentPath.add(root.val);
      if(root.val == sum && root.left==null && root.right==null){
          allPaths.add(new ArrayList<Integer>(currentPath));
      }
      else{
          recursiveTraversal(root.left, allPaths, currentPath, sum-root.val);
          recursiveTraversal(root.right, allPaths, currentPath, sum-root.val);
      }
      currentPath.remove(currentPath.size()-1);
  }/*
  Time Complexity: O(N^2) => O(N*logN) if the tree is balanced
  Space Complexity: O(N^2) => O(N*logN) if the tree is balanced
  */

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    int sum = 23;
    List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
    System.out.println("Tree paths with sum " + sum + ": " + result);
  }
}
