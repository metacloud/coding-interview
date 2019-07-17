/*
Pattern: In-place Reversal of a LinkedList
02 Reverse a Sub-list (medium)

Given the head of a LinkedList and two positions ‘p’ and ‘q’, reverse the LinkedList from position ‘p’ to ‘q’.

# LeetCode 92. Reverse Linked List II [Medium]
[Result]
Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List II.
Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for Reverse Linked List II.
*/

class ListNode {
  int value  = 0;
  ListNode next;

  ListNode(int value){
    this.value = value;
  }
}

class ReverseSubList {
    public static ListNode reverse(ListNode head, int p, int q){
        if(p==q) return head;

        ListNode current = head;
        ListNode previous = null;
        for(int i=0; current != null && i < p-1; i++){
          previous = current;
          current = current.next;
        }

        // position: p-1
        ListNode beforeReversed = previous;
        // current position: p, but will be the last node of the Reversed Part
        ListNode lastNodeReversed = current;

        for(int i=0; current != null && i<q-p+1; i++){
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        /*
        previous: first node of the Reversed Part 
        current position: q+1
        */

        // get correct position with the first part
        if(beforeReversed != null){ // p != 0
            beforeReversed.next = previous;
        } else{ // p==0
            head = previous;
        }
        // connect with the last part
        lastNodeReversed.next = current;
        return head;
    }/*
    Time Complexity: O(N)
    Space Complexity: O(1)
    */
}
