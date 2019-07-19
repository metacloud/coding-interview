/*
Pattern: Two Heaps
01 Find the Median of a Number Stream (medium)

Design a class to calculate the median of a number stream.

# LeetCode 295. Find Median from Data Stream [Hard]
[Result]
Runtime: 106 ms, faster than 92.79% of Java online submissions for Find Median from Data Stream.
Memory Usage: 63.7 MB, less than 79.19% of Java online submissions for Find Median from Data Stream.
*/

class MedianOfAStream {
  PriorityQueue<Integer> minHeap;
  PriorityQueue<Integer> maxHeap;

  public MedianFinder() {
    minHeap = new PriorityQueue<>((a,b)->(a-b));
    maxHeap = new PriorityQueue<>((a,b)->(b-a));
  }

  public void addNum(int num){ // O(logN) : Insertion in the heap.
    if(maxHeap.isEmpty() || maxHeap.peek() >= num) maxHeap.add(num);
    else minHeap.add(num);
    // adjust Heaps
    if(maxHeap.size() < minHeap.size()){
      maxHeap.add(minHeap.poll());
    } else if(maxHeap.size() > minHeap.size()+1){
      minHeap.add(maxHeap.poll());
    }
  }

  public double findMedian() { // O(1)
    if(maxHeap.size()==minHeap.size()){
      return ((maxHeap.peek()+minHeap.peek())/2.0);
    }
    return maxHeap.peek();
  }
  /*
  Time Complexity: O(logN)
  Space Complexity: O(N) as we will be storing all the numbers.
  */
}
