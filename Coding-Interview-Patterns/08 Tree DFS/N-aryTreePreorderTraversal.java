/*
589. N-ary Tree Preorder Traversal
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ret = new ArrayList<>();
        if(root==null) return ret;
        dfsHelper(root, ret);
        return ret;
    }
    
    private void dfsHelper(Node root, List<Integer> ret){
        if(root==null) return;
        
        ret.add(root.val);
        for(Node node : root.children){
            dfsHelper(node, ret);
        }
    }
}/*
Time & Space Complexity: O(N)
*/