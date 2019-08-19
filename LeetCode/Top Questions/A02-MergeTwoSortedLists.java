/*
21. Merge Two Sorted Lists
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode prehead = new ListNode(-1);
        ListNode ret = prehead;

        while(l1 !=null && l2 !=null){
            if(l1.val <= l2.val) {
                ret.next = l1;
                l1 = l1.next;
            }
            else if(l2.val< l1.val){
                ret.next = l2;
                l2 = l2.next;
            }
            ret = ret.next;
        }

        if(l1==null && l2!=null) ret.next = l2;
        if(l1!=null && l2==null) ret.next = l1;

        return prehead.next;
    }
}/*
Time Space: O(l1+l2)
Space Complexity: O(1)
*/
