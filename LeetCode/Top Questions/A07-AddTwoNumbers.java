/*
2. Add Two Numbers
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode prehead = new ListNode(-1);
        ListNode curr = prehead;
        int carry = 0;
        while(l1!=null || l2!=null){
            int val1 = (l1 !=null ? l1.val : 0);
            int val2 = (l2 !=null ? l2.val : 0);

            int sum = val1 + val2 + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        return prehead.next;
    }
}/*
Time Complexity: O(max(m,n)) where m and n is the length of l1 and l2.
Space Complexity: O(max(m,n)). The length of the new list is at most max(m,n)+1 (carry)
*/
