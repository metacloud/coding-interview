
/*
Pattern: Tree BFS
09 Right View of a Binary Tree (easy)

Given a binary tree, return an array containing nodes in its right view.
The right view of a binary tree is the set of nodes visible when the tree is seen from the right side.

[Example]
       1
     /  \
    2    3
   / \  / \
  4  5 6   7
 /
3
Right View: [1,3,7,3]

# LeetCode 199. Binary Tree Right Side View [Medium]
Runtime: 1 ms, faster than 95.82% of Java online submissions for Binary Tree Right Side View.
Memory Usage: 35.4 MB, less than 99.98% of Java online submissions for Binary Tree Right Side View.
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

class RightViewTree {

  public static List<TreeNode> traverse(TreeNode root) {
    List<TreeNode> rightViewTree = new ArrayList<>();

    if(root==null) return rightViewTree;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while(!queue.isEmpty()){

        int numNodes = queue.size();
        for(int i=0; i < numNodes; i++){
          TreeNode curr = queue.poll();
          if(curr.left != null) queue.offer(curr.left);
          if(curr.right != null) queue.offer(curr.right);

          if(i == numNodes-1){
            rightViewTree.add(curr);
          }
        }
    }
    return rightViewTree;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    root.left.left.left = new TreeNode(3);
    List<TreeNode> result = RightViewTree.traverse(root);
    for (TreeNode node : result) {
      System.out.print(node.val + " ");
    }
  }
}



// LeetCode 199. Binary Tree Right Side View
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideValue = new ArrayList<>();
        if(root == null) return rightSideValue;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){

            int numNodes = queue.size();
            for(int i=0; i<numNodes; i++){
                TreeNode curr = queue.poll();
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);

                if(i == numNodes-1){
                    rightSideValue.add(curr.val);
                }
            }

        }
        return rightSideValue;
    }
}
