
/*
Pattern: In-place Reversal of a LinkedList
01 Reverse every K-element Sub-list (medium)

Given the head of a LinkedList and a number ‘k’, reverse every ‘k’ sized sub-list starting from the head.
If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.

[Example]
1->2->3->4->5->6->7->8->null

K=3
3->2->1->6->5->4->8->7->null
*/

import java.util.*;

class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class ReverseEveryKElements {

  public static ListNode reverse(ListNode head, int k){

    if(k <= 1 || head == null) return head;

    ListNode curr = head;
    ListNode prev = null;

    while(curr != null){

      ListNode Reversed = curr;
      ListNode beforeReversed = prev;

      for(int i=0; i<k && curr!=null; i++){
          ListNode temp = curr.next;
          curr.next = prev;
          prev = curr;
          curr = temp;
      }

      if(beforeReversed != null){ //connect with the prev part
        beforeReversed.next = prev;
      }
      else {
        head = prev;
      }

      Reversed.next = curr;
      prev = Reversed;
    }
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
    head.next.next.next.next.next = new ListNode(6);
    head.next.next.next.next.next.next = new ListNode(7);
    head.next.next.next.next.next.next.next = new ListNode(8);

    ListNode result = ReverseEveryKElements.reverse(head, 3);
    System.out.print("Nodes of the reversed LinkedList are: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
  }
}
