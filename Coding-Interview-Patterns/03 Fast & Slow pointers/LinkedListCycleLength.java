/*
Pattern: Fast & Slow pointers
01.5 LinkedList Cycle Length (easy)

Given the head of a LinkedList with a cycle, find the length of the cycle.
*/

class ListNode {
  int value = 0;
  ListNode next;
  
  ListNode(int value){
    this.value = value;
  }
}

class LinkedListCycleLength{
    public static int findCycleLength(ListNode head){
      ListNode slow = head;
      ListNode fast = head;

      while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
        if(slow == fast){
          return getCycleLength(slow);
        }
      }
      return 0; // no cycle
    }

    private static int getCycleLength(ListNode slow){
        ListNode current = slow;
        int cycleLength = 0;
        do {
          current = current.next;
          cycleLength++;
        } while(current != slow);
  
        return cycleLength;
    }/*
    Time Complexity: O(N)
    Space Complexity: O(1)
    */
}
