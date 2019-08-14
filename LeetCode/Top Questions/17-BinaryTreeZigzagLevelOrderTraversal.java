/*
103. Binary Tree Zigzag Level Order Traversal
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root==null) return ret;

        //level by level : BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean fromLeft = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currLevel = new ArrayList<>();

            for(int i=0; i<size; i++){
                TreeNode temp = queue.poll();
                if(temp.left!=null) queue.offer(temp.left);
                if(temp.right!=null) queue.offer(temp.right);

                if(fromLeft){
                    currLevel.add(temp.val);
                } else{ //fromRight
                    currLevel.add(0, temp.val);
                }
            }
            ret.add(new ArrayList<>(currLevel));
            if(fromLeft) fromLeft = false;
            else fromLeft = true;
        }
     return ret;
    }
}
/*
Time complexity
The time complexity of the above algorithm is O(N), where ‘N’ is the total number of nodes in the tree. This is due to the fact that we traverse each node once.

Space complexity
The space complexity of the above algorithm will be O(N) as we need to return a list containing the level order traversal. We will also need O(N) space for the queue. Since we can have a maximum of N/2 nodes at any level (this could happen only at the lowest level), therefore we will need O(N) space to store them in the queue.
*/
