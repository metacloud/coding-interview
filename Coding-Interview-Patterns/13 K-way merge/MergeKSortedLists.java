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

class ListNode {
  int value;
  ListNode next;

  ListNode(int value){
    this.value = value;
  }
}

class MergeKSortedLists {
    public ListNode merge(ListNode[] lists){
      //minHeap
      PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((a,b)-> (a.value-b.value));
      for(ListNode root : lists){
        if(root != null)
          minHeap.add(root);
      }
      ListNode prehead = new ListNode(-1);
      ListNode prev = prehead;
      while(!minHeap.isEmpty()){
          ListNode minNode = minHeap.poll();
          prev.next = minNode;
          prev = prev.next;
          if(minNode.next != null) {
            minHeap.add(minNode.next);
          }
      }
      return prehead.next;
    }
}/*
Time Complexity: O(NlogK) where K is the number of linked lists.
Space Complexity: O(K)
*/
