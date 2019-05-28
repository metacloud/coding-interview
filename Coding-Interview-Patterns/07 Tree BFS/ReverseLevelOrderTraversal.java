
/*
Pattern: Tree BFS
02 Reverse Level Order Traversal (easy)

Given a binary tree, populate an array to represent its level-by-level traversal in reverse order,
i.e., the lowest level comes first.
You should populate the values of all nodes in each level from left to right in separate sub-arrays.
*/


import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x){
    this.val = x;
  }
};

class ReverseLevelOrderTraversal{
  public static List<List<Integer>> traverse(TreeNode root){
      List<List<Integer>> result = new LinkedList<List<Integer>>();
      if(root==null) return result;

      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      while(!queue.isEmpty()){
        int nodesLevel = queue.size();
        List<Integer> currentLevel = new ArrayList<Integer>(nodesLevel);

        for(int i=0; i<nodesLevel; i++){
            TreeNode currentNode = queue.poll();
            currentLevel.add(currentNode.val);

            if(currentNode.left != null) {
              queue.offer(currentNode.left);
            }
            if(currentNode.right != null){
              queue.offer(currentNode.right);
            }
        }
        result.add(0, currentLevel);
      }

      return result;
  }/*
  Time Complexity: O(N)
  Space Complexity: O(N)
  */

  public static void main(String[] args){
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
    System.out.println("Reverse level order traversal: " + result);
  }
}
