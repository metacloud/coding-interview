/*
Pattern: Tree BFS
03 Zigzag Traversal (medium)

Given a binary tree, populate an array to represent its zigzag level order traversal.
You should populate the values of all nodes of the first level from left to right,
then right to left for the next level and keep alternating in the same manner for the following levels.

     1
   /   \
  2     3
 / \   / \
4  5  6   7   Zigzag Level Order Traversal: [[1], [3,2], [4,5,6,7]]

# LeetCode 103. Binary Tree Zigzag Level Order Traversal
[Result]
Runtime: 1 ms, faster than 88.41% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
Memory Usage: 36.3 MB, less than 99.93% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
*/
public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public List< List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if(root==null) return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    
    boolean reversed = false;
    while(!queue.isEmpty()){
        int levelSize = queue.size();
        List<Integer> levelNodes = new ArrayList<>();
        for(int i=0; i<levelSize; i++){
            TreeNode temp = queue.poll();
            if(reversed){ 
              levelNodes.add(0, temp.val);
            } else { // reversed == false
              levelNodes.add(temp.val);
            }
            if(temp.left != null) queue.offer(temp.left);
            if(temp.right != null)  queue.offer(temp.right);
        }
        if(reversed){
         reversed = false;
        } else reversed = true;
        result.add(levelNodes);
    }
    return result;
}
