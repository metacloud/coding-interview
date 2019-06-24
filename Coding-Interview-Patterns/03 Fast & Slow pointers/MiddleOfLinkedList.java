
/*
Pattern: Fast & Slow pointers
04 Middle of the LinkedList (easy)

Given the head of a Singly LinkedList,
write a method to return the middle node of the LinkedList.
If the total number of nodes in the LinkedList is even, return the second middle node.

# LeetCode 876. Middle of the Linked List [Easy]
[Result]
Runtime: 0 ms, faster than 100.00% of Java online submissions for Middle of the Linked List.
Memory Usage: 33.9 MB, less than 100.00% of Java online submissions for Middle of the Linked List.
*/


class ListNode {

  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class MiddleOfLinkedList {

  public static ListNode findMiddle(ListNode head) {

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }/*
  Time Complexity: O(N) where N is the total number of nodes in the LinkedList
  Space Complexity: O(1)
  */


  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);

    head.next.next.next.next.next = new ListNode(6);
    System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);

    head.next.next.next.next.next.next = new ListNode(7);
    System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);
  }
}
