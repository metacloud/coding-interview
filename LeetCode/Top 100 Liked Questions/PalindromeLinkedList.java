/*
LeetCode 234. Palindrome Linked List

[Result]
Runtime: 1 ms, faster than 99.12% of Java online submissions for Palindrome Linked List.
Memory Usage: 41.7 MB, less than 43.96% of Java online submissions for Palindrome Linked List.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;

        // 1. find the middle of the LinkedList
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // 2. reverse the secondHalf (from slow to the end)
        ListNode reversed = null;
        while(slow != null){
            ListNode temp = slow.next;
            slow.next = reversed;
            reversed = slow;
            slow = temp;
        }
        
        // 3. check if the LinkedList is a palindrome or not
        while(head!=null && reversed!=null ){
            if(head.val != reversed.val) return false;
            head = head.next;
            reversed = reversed.next;
        }
        return true;
    }
}/*
Time Complexity: O(N)
Space Complexity: O(1)
*/