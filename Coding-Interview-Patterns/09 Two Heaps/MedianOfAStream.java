/*
Pattern: Two Heaps
01 Find the Median of a Number Stream (medium)

Design a class to calculate the median of a number stream.
The class should have the following two methods:

1. insertNum(int num): stores the number in the class
2. findMedian(): returns the median of all numbers inserted in the class
If the count of numbers inserted in the class is even, the median will be the average of the middle two numbers.
*/

//default PriorityQueue : Implemented with Min-Heap
// Max-Heap with

import java.util.*;

class MedianOfAStream {

  PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x,y)->Integer.compare(y,x)); // first half of the nums
  PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // second half of the nums

  public void insertNum(int num){ // O(logN) : Insertion in the heap.
    if(maxHeap.isEmpty() || maxHeap.peek() >= num) maxHeap.add(num);
    else minHeap.add(num);

    if(maxHeap.size() > minHeap.size()+1){
      minHeap.add(maxHeap.poll());
    } else if (maxHeap.size() < minHeap.size()){
      maxHeap.add(minHeap.poll());
    }
  }


  public double findMedian() { // O(1)
    if(maxHeap.size() == minHeap.size()){//even number
      return (double)(maxHeap.peek()+minHeap.peek()) / 2;
    }
    return maxHeap.peek();
  }
  /*
  Time Complexity: O(logN)
  Space Complexity: O(N)
  */

  public static void main(String[] args) {
    MedianOfAStream medianOfAStream = new MedianOfAStream();
    medianOfAStream.insertNum(3);
    medianOfAStream.insertNum(1);
    System.out.println("The median is: " + medianOfAStream.findMedian());
    medianOfAStream.insertNum(5);
    System.out.println("The median is: " + medianOfAStream.findMedian());
    medianOfAStream.insertNum(4);
    System.out.println("The median is: " + medianOfAStream.findMedian());
  }
}
