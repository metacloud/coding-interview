
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

    public static int getCycleLength(ListNode slow){

        ListNode curr = slow.next;
        int lenCycle = 1; // Included Node of slow position
        while(curr != slow){
          lenCycle++;
          curr = curr.next;
        }
        return lenCycle;
    }

    public static void main(String[] args) {
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);
      head.next.next.next.next.next = new ListNode(6);
      head.next.next.next.next.next.next = head.next.next;
      System.out.println("LinkedList cycle length: " + LinkedListCycleLength.findCycleLength(head));

      head.next.next.next.next.next.next = head.next.next.next;
      System.out.println("LinkedList cycle length: " + LinkedListCycleLength.findCycleLength(head));
    }
}
