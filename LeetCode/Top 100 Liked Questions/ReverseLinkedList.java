/*
LeetCode 206. Reverse Linked List

[Result]
Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
Memory Usage: 37.1 MB, less than 99.79% of Java online submissions for Reverse Linked List.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution { // Iterative
    public ListNode reverseList(ListNode head) {
        
        ListNode reversed = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = reversed;
            reversed = head;
            head = temp;
        }
        return reversed;
    }
}/*
Time Complexity: O(N)
Space Complexity: O(1)
*/

class Solution { // Recursive
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode reversedHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reversedHead;
    }
}/*
Time Complexity: O(N)
Space Complexity: O(N)
*/