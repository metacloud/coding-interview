/*
Pattern: Tree BFS
01 Binary Tree Level Order Traversal (easy)

Given a binary tree, populate an array to represent its level-by-level traversal.
You should populate the values of all nodes of each level from left to right in separate sub-arrays.

# LeetCode 102. Binary Tree Level Order Traversal [Medium]
[Result]
Runtime: 1 ms, faster than 85.33% of Java online submissions for Binary Tree Level Order Traversal.
Memory Usage: 36.2 MB, less than 99.98% of Java online submissions for Binary Tree Level Order Traversal.
*/

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int value){
    this.val = value;
  }
};

class LevelOrderTraversal {
  public List<List<Integer>> traverse(TreeNode root){
    List<List<Integer>> result = new ArrayList<>();
    if(root==null) return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while(!queue.isEmpty()){
      int nodesLevel = queue.size();
      List<Integer> currentLevel = new ArrayList<>(nodesLevel);

      for(int i=0; i<nodesLevel; i++){
          TreeNode currentNode = queue.poll();
          currentLevel.add(currentNode.val);
          if(currentNode.left != null) queue.offer(currentNode.left);
          if(currentNode.right != null) queue.offer(currentNode.right);
      }
      result.add(currentLevel);
    }

    return result;
  }/*
  Time Complexity: O(N)
  Space Complexity: O(N)
  */
}

// Using Recursion
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        recursiveTraversal(root, 0, result);
        return result;
    }

    public void recursiveTraversal(TreeNode root, int level, List<List<Integer>> result){
        if(root==null) return;
        if(result.size() <= level){
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(root.val);
        recursiveTraversal(root.left, level+1, result);
        recursiveTraversal(root.right, level+1, result);
    }
}
