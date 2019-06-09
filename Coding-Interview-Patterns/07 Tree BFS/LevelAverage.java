
/*
Pattern: Tree BFS
04 Level Averages in a Binary Tree (easy)

Given a binary tree, populate an array to represent the averages of all of its levels.

# LeetCode 637. Average of Levels in Binary Tree [Easy]
[Result]
Runtime: 2 ms, faster than 98.77% of Java online submissions for Average of Levels in Binary Tree.
Memory Usage: 40.3 MB, less than 94.49% of Java online submissions for Average of Levels in Binary Tree.
*/

import java.util.*;
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  public TreeNode(int val){
    this.val = val;
  }
};

class LevelAverage {
  public static List<Double> findLevelAverages(TreeNode root){
    List<Double> result = new ArrayList<>();
    if(root==null) return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()){
      double levelSum = 0;
      int levelSize = queue.size();

      for(int i=0; i<levelSize; i++){
        TreeNode current = queue.poll();
        levelSum += current.val;
        if(current.left!=null) queue.offer(current.left);
        if(current.right!=null) queue.offer(current.right);
      }
      result.add(levelSum/levelSize);
    }
    return result;
  }/*
  Time Complexity: O(N) where N is the total number of nodes in the tree.
  Space Complexity: O(N) which is required for the queue.
  */

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.left.right = new TreeNode(2);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    List<Double> result = LevelAverage.findLevelAverages(root);
    System.out.print("Level averages are: " + result);
  }
}
