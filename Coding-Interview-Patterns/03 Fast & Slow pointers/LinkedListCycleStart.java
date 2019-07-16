/*
Pattern: Fast & Slow pointers
02 Start of LinkedList Cycle (medium)

Given the head of a Singly LinkedList that contains a cycle,
write a function to find the starting node of the cycle.

# 142. Linked List Cycle II (Medium)
[Result]
Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle II.
Memory Usage: 35.5 MB, less than 5.04% of Java online submissions for Linked List Cycle II.
*/

class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value){
    this.value = value;
  }
}

class LinkedListCycleStart {
    public static ListNode detectCycle(ListNode head){      
      ListNode slow = head;
      ListNode fast = head;
      while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
        if(slow==fast){
          int cycleLength = getCycleLength(slow);
          return findStartingNodeCycle(head, cycleLength);
        }
      }
      return null; // no cycle
    }

    private static int getCycleLength(ListNode slow){
      ListNode current = slow;
      int cycleLength = 0;
      do {
        current = current.next;
        cycleLength++;
      } while(current != slow);
      return cycleLength;
    }

    private static ListNode findStartingNodeCycle(ListNode head, int cycleLength){
      ListNode pointer1 = head;
      ListNode pointer2 = head;
      for(int i=0; i<cycleLength; i++){
        pointer2 = pointer2.next;
      }
      while(pointer1 != pointer2){
        pointer1 = pointer1.next;
        pointer2 = pointer2.next;
      }
      return pointer1;
    }
}/*
  Time Complexity: O(N)
  Space Complexity: O(1)
  */
