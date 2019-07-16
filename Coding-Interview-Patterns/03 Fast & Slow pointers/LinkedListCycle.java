/*
Pattern: Fast & Slow pointers
01 LinkedList Cycle (easy)

Given the head of a Singly LinkedList,
write a function to determine if the LinkedList has a cycle in it or not.

# LeetCode 141. Linked List Cycle [Easy]
[Result]
Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle.
Memory Usage: 36 MB, less than 99.94% of Java online submissions for Linked List Cycle.
*/
class ListNode {
  int value = 0;
  ListNode next;
  ListNode(int value){
    this.value = value;
  }
}

class LinkedListCycle {
    public static boolean hasCycle(ListNode head){
      ListNode slow = head;
      ListNode fast = head;

      while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
        if(slow == fast){
          return true;
        }
      }
      return false;
    }/*
    Time Complexity: O(N) where N is the total number of nodes in the LinkedList.
    Space Complexity: O(1)
    */
}
