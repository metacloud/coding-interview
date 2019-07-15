/*
Pattern: Tree BFS
08 Connect All Level Order Siblings (medium)

Given a binary tree, connect each node with its level order successor. 
The last node of each level should point to the first node of the next level.
*/
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode next;

  TreeNode(int x) {
    val = x;
    left = right = next = null;
  }
};

class ConnectAllSiblings {
  public void connect(TreeNode root) {
    if(root==null || root.left == null && root.right == null) return;  	
    IterativeBFS(root);
  }
  private void IterativeBFS(TreeNode root){
  	Queue<TreeNode> queue = new LinkedList<>();
  	queue.offer(root);
  	while(!queue.isEmpty()){
  		TreeNode curr = queue.poll();
  		if(curr.left != null) queue.offer(curr.left);
  		if(curr.right != null) queue.offer(curr.right);
  		if(queue.peek() != null){
	  		curr.next = queue.peek();
  		} else curr.next = null;	
  	}
  }
}