
/*
Pattern: Fast & Slow pointers
05 Palindrome LinkedList (medium)



# LeetCode 234. Palindrome Linked List [Easy]
[Result]
Runtime: 1 ms, faster than 98.37% of Java online submissions for Palindrome Linked List.
Memory Usage: 40 MB, less than 99.94% of Java online submissions for Palindrome Linked List.
*/

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){ //to get the middle of the LinkedList
          slow = slow.next;
          fast = fast.next.next;
        }

        ListNode curr = slow;
        ListNode reverse = null;

        while(curr!= null){ // to get reversed sub-LinkedList(secondHalf)
          ListNode temp = curr.next;
          curr.next = reverse;
          reverse = curr;
          curr = temp;
        }

        ListNode start = head;
        while(reverse !=null){
          if(start.val != reverse.val){
            return false;
          } else {
            start = start.next;
            reverse = reverse.next;
          }
        }
        return true;
  }
}
