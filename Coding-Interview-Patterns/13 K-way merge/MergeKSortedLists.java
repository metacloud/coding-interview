
/*
Pattern: K-way merge
01 Merge K Sorted Lists (medium)

Given an array of ‘K’ sorted LinkedLists, merge them into one sorted list.
Input: L1=[2, 6, 8], L2=[3, 6, 7], L3=[1, 3, 4]
Output: [1, 2, 3, 3, 4, 6, 6, 7, 8]

# LeetCode 23. Merge k Sorted Lists [Hard]
[Result] : PriorityQueue
Runtime: 35 ms, faster than 39.95% of Java online submissions for Merge k Sorted Lists.
Memory Usage: 43.3 MB, less than 18.58% of Java online submissions for Merge k Sorted Lists.
*/

import java.util.*;

class ListNode {
  int value;
  ListNode next;

  ListNode(int value){
    this.value = value;
  }
}

class MergeKSortedLists {
    public static ListNode merge(ListNode[] lists){
      //minHeap
      PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((n1,n2)-> Integer.compare(n1.value, n2.value));

      for(ListNode root : lists){
        if(root != null)
          minHeap.add(root);
      }

      ListNode sortedHead = null;
      ListNode sortedTail = null;

      while(!minHeap.isEmpty()){
          ListNode minNode = minHeap.poll();

          if(sortedHead == null){
              sortedHead = minNode;
              sortedTail = minNode;
          } else {
            sortedTail.next = minNode;
            sortedTail = sortedTail.next;
          }
          if(minNode.next != null) {
            minHeap.add(minNode.next);
          }
      }
      return sortedHead;
    }


    public static void main(String[] args) {
      ListNode l1 = new ListNode(2);
      l1.next = new ListNode(6);
      l1.next.next = new ListNode(8);

      ListNode l2 = new ListNode(3);
      l2.next = new ListNode(6);
      l2.next.next = new ListNode(7);

      ListNode l3 = new ListNode(1);
      l3.next = new ListNode(3);
      l3.next.next = new ListNode(4);

      ListNode result = MergeKSortedLists.merge(new ListNode[] {l1, l2, l3});
      System.out.println("Here are the elements from the merged list: ");
      while(result != null){
        System.out.print(result.value + " ");
        result = result.next;
      }
    }
}
