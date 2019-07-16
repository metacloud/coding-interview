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
    ListNode reversed = null, temp = null;
    while(current != null){
      temp = current.next;
      current.next = reversed;
      reversed = current;
      current = temp;
    }
    return reversed;
  }/*
  Time Complexity: O(N)
  Space Complexity: O(1)
  */
}
