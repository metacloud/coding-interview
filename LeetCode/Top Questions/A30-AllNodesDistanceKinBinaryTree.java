/*
863. All Nodes Distance K in Binary Tree
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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> ret = new ArrayList<>();
        if(root==null) return ret;

        Map<TreeNode, TreeNode> checkParent = new HashMap<>();
        dfsHelper(checkParent, root, null);

        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target); visited.add(target);

        while(!queue.isEmpty()){
            int size = queue.size();
            if(K==0){
                while(size-- > 0){
                    ret.add(queue.poll().val);
                }
                return ret;
            }
            for(int i=0; i<size; i++){
                TreeNode temp = queue.poll();
                if(temp.left!=null && !visited.contains(temp.left)){
                    queue.offer(temp.left); visited.add(temp.left);
                }
                if(temp.right!=null && !visited.contains(temp.right)){
                    queue.offer(temp.right); visited.add(temp.right);
                }
                if(checkParent.get(temp)!=null && !visited.contains(checkParent.get(temp))){
                    queue.offer(checkParent.get(temp)); visited.add(checkParent.get(temp));
                }
            }
            K--;
        }
        return ret;
    }

    public void dfsHelper(Map<TreeNode, TreeNode> map, TreeNode root, TreeNode parent){
        if(root==null) return;
        map.put(root, parent);
        dfsHelper(map, root.left, root);
        dfsHelper(map, root.right, root);
    }

}/*
Time Complexity: O(N+M) where N is the number of nodes and M is the number of edges.
Since Always edges = nodes-1 so that O(N+(N-1))~= O(N)
Space Complexity: O(N)
*/
