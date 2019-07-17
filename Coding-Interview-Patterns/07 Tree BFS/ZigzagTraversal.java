/*
Pattern: Tree BFS
03 Zigzag Traversal (medium)

Given a binary tree, populate an array to represent its zigzag level order traversal.
You should populate the values of all nodes of the first level from left to right,
then right to left for the next level and keep alternating in the same manner for the following levels.

# LeetCode 103. Binary Tree Zigzag Level Order Traversal [Medium]
[Result]
Runtime: 1 ms, faster than 88.41% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
Memory Usage: 36.3 MB, less than 99.93% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
*/
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class ZigzagTraversal {
    public List< List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean fromLeft = false;
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            for(int i=0; i<levelSize; i++){
                TreeNode temp = queue.poll();
                if(temp.left != null) queue.offer(temp.left);
                if(temp.right != null)  queue.offer(temp.right);
                if(fromLeft) {
                    levelNodes.add(0, temp.val);
                } else { // fromLeft == false
                  levelNodes.add(temp.val);
                }
            }
            if(fromLeft) fromLeft = false;
            else fromLeft = true;
            
            result.add(levelNodes);
        }
        return result;
    }
}/*
Time Complexity: O(N)
Space Complexity: O(N)
*/
