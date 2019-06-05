
/*
Pattern: In-place Reversal of a LinkedList
02 Reverse a Sub-list (medium)

Given the head of a LinkedList and two positions ‘p’ and ‘q’, reverse the LinkedList from position ‘p’ to ‘q’.

# LeetCode 92. Reverse Linked List II [Medium]
[Result]
Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List II.
Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for Reverse Linked List II.
*/

import java.util.*;

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
        for(int i=0; current != null && i <p-1; i++){
          previous = current;
          current = current.next;
        }

        //first part before index 'p'
        ListNode leftSubList = previous;
        //second part between index 'p' and index 'q'
        ListNode SubList = current;
        for(int i=0; current != null && i<q-p+1; i++){
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }

        // get correct position with the first part
        if(leftSubList != null){
            leftSubList.next = previous;
        } else{
            head = previous;
        }

        // connect with the last part
        SubList.next = current;

        return head;
    }/*
    Time Complexity: O(N)
    Space Complexity: O(1)
    */

    public static void main(String[] args) {
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);

      ListNode result = ReverseSubList.reverse(head, 2, 4);
      System.out.print("Nodes of the reversed LinkedList are: ");
      while (result != null) {
        System.out.print(result.value + " ");
        result = result.next;
      }
    }
}
