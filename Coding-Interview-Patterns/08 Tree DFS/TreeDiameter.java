
/*
Pattern: Tree DFS
06 Count Paths for a Sum (medium)

Given a binary tree, find the length of its diameter.
The diameter of a tree is the number of nodes on the longest path between any two leaf nodes.
The diameter of a tree may or may not pass through the root.

    1
  /  \
 2    3
 |   / \
 4  5  6

Output: 5
The diameter of the tree : [4, 2, 1, 3, 6]

# LeetCode 543. Diameter of Binary Tree [Easy]
Runtime: 0 ms, faster than 100.00% of Java online submissions for Diameter of Binary Tree.
Memory Usage: 39.3 MB, less than 23.11% of Java online submissions for Diameter of Binary Tree.
*/

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class TreeDiameter {
  int maxDia = 0;
  public int findDiameter(TreeNode root) {
    maxDepth(root);
    return maxDia;
  }

  public int maxDepth(TreeNode root){
    if(root==null) return 0;
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    maxDia = Math.max(maxDia, left + right + 1);
    return 1 + Math.max(left, right);
  }
}


// LeetCode : Instead of the number of nodes => find the length of the longest path between any two nodes.
class Solution {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    public int maxDepth(TreeNode root){
        if(root==null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        max = Math.max(max, left+right);
        return 1 + Math.max(left, right);
    }
}
