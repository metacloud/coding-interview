
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

/*
Time Complexity: O(N)
Space Complexity: O(1)
*/
class LinkedListCycleStart {
    public static ListNode detectCycle(ListNode head){
      int cycleLength = 0;
      ListNode slow = head;
      ListNode fast = head;
      while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
        if(slow==fast){
          cycleLength = getCycleLength(slow);
          break;
        }
      }
      if(cycleLength == 0){ //no cycle
        return null;
      }
      return findStartingNodeCycle(head, cycleLength);
    }

    private static int getCycleLength(ListNode slow){
      ListNode current = slow.next;
      int cycleLength = 1;
      while(current != slow){
        cycleLength++;
        current = current.next;
      }
      return cycleLength;
    }

    private static ListNode findStartingNodeCycle(ListNode head, int cycleLength){
      ListNode pointer1 = head, pointer2 = head;
      while(cycleLength > 0){
        pointer2 = pointer2.next;
        cycleLength--;
      }
      while(pointer1 != pointer2){
        pointer1 = pointer1.next;
        pointer2 = pointer2.next;
      }
      return pointer1;
    }


    public static void main(String[] args) {
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);
      head.next.next.next.next.next = new ListNode(6);

      head.next.next.next.next.next.next = head.next.next;
      System.out.println("LinkedList cycle start: " + LinkedListCycleStart.detectCycle(head).value);

      head.next.next.next.next.next.next = head.next.next.next;
      System.out.println("LinkedList cycle start: " + LinkedListCycleStart.detectCycle(head).value);

      head.next.next.next.next.next.next = head;
      System.out.println("LinkedList cycle start: " + LinkedListCycleStart.detectCycle(head).value);
    }
}
