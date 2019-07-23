/*
LeetCode 21. Merge Two Sorted Lists

[Result]
Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
Memory Usage: 40.8 MB, less than 10.44% of Java online submissions for Merge Two Sorted Lists.
*/

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }
}/*
Time Complexity: O(N) where N is the total number of elements in l1 + l2 
Space Complexity: O(1)
*/

