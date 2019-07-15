/*
Pattern: Tree BFS
07 Connect Level Order Siblings (medium)

Given a binary tree, connect each node with its level order successor. 
The last node of each level should point to a null node.

# LeetCode 116. Populating Next Right Pointers in Each Node [Medium]
Runtime: 0 ms, faster than 100.00% of Java online submissions for Populating Next Right Pointers in Each Node.
Memory Usage: 35.3 MB, less than 98.63% of Java online submissions for Populating Next Right Pointers in Each Node.
*/
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

class Solution {
    public Node connect(Node root) {
        if(root==null || root.left==null && root.right==null) return root;
        return IterativeBFS(root);    
    }
    
    private Node IterativeBFS(Node root){
      Queue<Node> queue = new LinkedList<>();
      queue.offer(root);
      queue.offer(null);

      while(!queue.isEmpty()){
        Node curr = queue.poll();
        if(curr != null){
          curr.next = queue.peek();
          if(curr.left != null) queue.offer(curr.left);
          if(curr.right != null) queue.offer(curr.right);
        }
        else if(!queue.isEmpty()){
          queue.offer(null);
        }
      }
      return root;
    }
}

