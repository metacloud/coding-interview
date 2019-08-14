/*
LeetCode 155. Min Stack

[Result]
Runtime: 45 ms, faster than 99.16% of Java online submissions for Min Stack.
Memory Usage: 40.3 MB, less than 31.40% of Java online submissions for Min Stack.
*/

class MinStack {
    
    class ListNode {
        int val;
        int min;
        ListNode next;
        
        ListNode(int val, int min, ListNode next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
    
    ListNode head;
    public void push(int x) {
        if(head==null){
            head = new ListNode(x, x, null);
        } 
        else {
            int min = Math.min(head.min, x);
            head = new ListNode(x, min, head);
        }
    }
    
    public void pop() {        
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */