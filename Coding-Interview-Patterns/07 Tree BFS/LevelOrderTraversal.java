
/*
Pattern: Tree BFS
01 Binary Tree Level Order Traversal (easy)

Given a binary tree, populate an array to represent its level-by-level traversal.
You should populate the values of all nodes of each level from left to right in separate sub-arrays.
*/


import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int value){
    this.val = value;
  }
};

class LevelOrderTraversal {
  public static List<List<Integer>> traverse(TreeNode root){
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if(root==null) return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while(!queue.isEmpty()){
      int nodesLevel = queue.size();
      List<Integer> currentLevel = new ArrayList<>(nodesLevel);

      for(int i=0; i<nodesLevel; i++){
          TreeNode currentNode = queue.poll();
          currentLevel.add(currentNode.val);

          if(currentNode.left != null){
            queue.offer(currentNode.left);
          }
          if(currentNode.right != null){
            queue.offer(currentNode.right);
          }
      }
      result.add(currentLevel);
    }
    return result;
  }/*
  Time Complexity: O(N)
  Space Complexity: O(N)
  */


  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    List<List<Integer>> result = LevelOrderTraversal.traverse(root);
    System.out.println("Level order traversal: " + result);
  }
}
