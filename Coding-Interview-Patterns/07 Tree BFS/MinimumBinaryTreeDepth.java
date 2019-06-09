
/*
Pattern: Tree BFS
05 Minimum Depth of a Binary Tree (easy)

Find the minimum depth of a binary tree.
The minimum depth is the number of nodes along the shortest path from the root node to the nearest leaf node.

# LeetCode 111. Minimum Depth of Binary Tree [Easy]
[Result]
Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Depth of Binary Tree.
Memory Usage: 39 MB, less than 97.74% of Java online submissions for Minimum Depth of Binary Tree.
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

class MinimumBinaryTreeDepth {

  public static int findDepth(TreeNode root){
    if(root==null) return 0;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int minDepth = 0;

    while(!queue.isEmpty()){
      minDepth++;
      int levelSize = queue.size();
      for(int i=0; i<levelSize; i++){
        TreeNode current = queue.poll();
        if(current.left == null && current.right == null) return minDepth;
        if(current.left != null) queue.offer(current.left);
        if(current.right != null) queue.offer(current.right);
      }
    }
    return minDepth;
  }/*
  Time Complexity: O(N)
  Space Complexity: O(N)
  */

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
    root.left.left = new TreeNode(9);
    root.right.left.left = new TreeNode(11);
    System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
  }
}
