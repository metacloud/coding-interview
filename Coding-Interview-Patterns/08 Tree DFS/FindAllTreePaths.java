/*
Pattern: Tree DFS
02 All Paths for a Sum (medium)

Given a binary tree and a number ‘S’,
find all paths from root-to-leaf such that the sum of all the node values of each path equals ‘S’.

# LeetCode 113. Path Sum II [Medium]
[Result]
Runtime: 1 ms, faster than 100.00% of Java online submissions for Path Sum II.
Memory Usage: 37.6 MB, less than 100.00% of Java online submissions for Path Sum II.
*/

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class FindAllTreePaths {
  public List<List<Integer>> findPaths(TreeNode root, int sum) {
      List<List<Integer>> allPaths = new ArrayList<>();
      if(root==null) return allPaths;

      List<Integer> currentPath = new ArrayList<>();
      recursiveTraversal(root, sum, currentPath, allPaths);
      return allPaths;
  }

  private void recursiveTraversal(TreeNode root, int sum, List<Integer> currentPath, List<List<Integer>> allPaths){
      if(root==null) return;
      
      currentPath.add(root.val);
      if(root.val == sum && root.left==null && root.right==null){
          allPaths.add(new ArrayList<Integer>(currentPath));
      }    
      recursiveTraversal(root.left, sum-root.val, currentPath, allPaths);
      recursiveTraversal(root.right, sum-root.val, currentPath, allPaths);
      // for backtracking
      currentPath.remove(currentPath.size()-1);
  }/*
  Time Complexity: O(N^2) => O(N*logN) if the tree is balanced
  Space Complexity: O(N^2) => O(N*logN) if the tree is balanced
  */
}
