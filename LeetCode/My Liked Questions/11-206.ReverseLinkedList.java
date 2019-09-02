/*
206. Reverse Linked List
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// 1. Iterative
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode reversed = null;
        while(curr !=null){
            ListNode temp = curr.next;
            curr.next = reversed;
            reversed = curr;
            curr = temp;
        }
        return reversed;
    }
}

// 2. Recursive
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode rev = reverseList(head.next); // rev=5; currHead=4
        head.next.next = head;
        head.next = null;
        return rev;
    }
}
