
/*
Pattern: In-place Reversal of a LinkedList
01 Reverse a LinkedList (easy)

Given the head of a Singly LinkedList,
reverse the LinkedList. Write a function to return the new head of the reversed LinkedList.

# LeetCode 206. Reverse Linked List [Easy]
[Result]
Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
Memory Usage: 37.2 MB, less than 99.77% of Java online submissions for Reverse Linked List.
*/


class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class ReverseLinkedList {

  public static ListNode reverse(ListNode head) {
    if(head==null || head.next==null) return head;

    ListNode current = head;
    ListNode reverse = null;
    ListNode temp = null;

    while(current != null){
      temp = current.next;
      current.next = reverse;
      reverse = current;
      current = temp;
    }

    return reverse;
  }/*
  Time Complexity: O(n)
  Space Complexity: O(1)
  */

  public static void main(String[] args) {
    ListNode head = new ListNode(2);
    head.next = new ListNode(4);
    head.next.next = new ListNode(6);
    head.next.next.next = new ListNode(8);
    head.next.next.next.next = new ListNode(10);

    ListNode result = ReverseLinkedList.reverse(head);
    System.out.print("Nodes of the reversed LinkedList are: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
  }
}
