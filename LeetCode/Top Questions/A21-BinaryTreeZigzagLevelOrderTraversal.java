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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) { //BFS
        List<List<Integer>> zigzagLevelOrder = new ArrayList<>();
        if(root==null) return zigzagLevelOrder;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean fromLeft = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currLevel = new ArrayList<>();

            for(int i=0; i<size; i++){
                TreeNode curr = queue.poll();
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);

                if(fromLeft) currLevel.add(curr.val);
                else currLevel.add(0, curr.val);
            }

            if(fromLeft) fromLeft = false;
            else fromLeft = true;
            zigzagLevelOrder.add(new ArrayList<>(currLevel));
        }
        return zigzagLevelOrder;
    }
}/*
Time Complexity: O(N)
Space Complexity: O(N)
*/
