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
 6  5 2   3
Sum = 12, Output = 3
3 paths with sum '12' : 7->5 , 1->9->2, 9->3

# LeetCode 437. Path Sum III
Runtime: 11 ms, faster than 46.58% of Java online submissions for Path Sum III.
Memory Usage: 40.4 MB, less than 69.31% of Java online submissions for Path Sum III.
*/

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class CountAllPathSum {
  public int countPaths(TreeNode root, int Sum) {
    if(root == null) return 0;
    return recursiveDFS(root, Sum) + countPaths(root.left, Sum) + countPaths(root.right, Sum);
  }

  private int recursiveDFS (TreeNode root, int sum){
      if(root == null) return 0;
      return (root.val == sum ? 1 : 0) + recursiveDFS(root.left, sum - root.val) + recursiveDFS(root.right, sum - root.val);
  }
}/*
Time Complexity: worst = O(N^2) for skewed tree, best = O(NlogN) for balanced tree
Space Complexity: O(N)
*/
