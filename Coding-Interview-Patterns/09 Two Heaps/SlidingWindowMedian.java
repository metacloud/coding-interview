/*
Pattern: Two Heaps
02 Sliding Window Median (hard)

Given an array of numbers and a number ‘k’, find the median of all the ‘k’ sized sub-arrays (or windows) of the array.

Input: nums=[1, 2, -1, 3, 5], k = 2
Output: [1.5, 0.5, 1.0, 4.0]
Explanation: Lets consider all windows of size ‘2’:

[1, 2, -1, 3, 5] -> median is 1.5
[1, 2, -1, 3, 5] -> median is 0.5
[1, 2, -1, 3, 5] -> median is 1.0
[1, 2, -1, 3, 5] -> median is 4.0

# LeetCode 480. Sliding Window Median [Hard]
[Result]

*/


import java.util.*;

class SlidingWindowMedian {

  PriorityQueue<Integer> minHeap = new PriorityQueue<>();
  PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

  public double[] findSlidingWindowMedian(int[] nums, int k) {
    double[] result = new double[nums.length - k + 1];

    for (int i = 0; i < nums.length; i++) {

      if (maxHeap.size() == 0 || maxHeap.peek() >= nums[i]) {
        maxHeap.add(nums[i]);
      } else {
        minHeap.add(nums[i]);
      }
      rebalanceHeaps();

      int windowStart = i - k + 1;
      if (windowStart >= 0) { // if we have at least 'k' elements in the sliding window

        if (maxHeap.size() == minHeap.size()) {
          result[windowStart] = maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        }
        else {
          result[windowStart] = maxHeap.peek();
        }

        // remove the the element going out of the sliding window
        int removed = nums[windowStart];
        if (removed <= maxHeap.peek()) {
          maxHeap.remove(removed);
        } else {
          minHeap.remove(removed);
        }
        rebalanceHeaps();
      }
    }
    return result;
  }


  private void rebalanceHeaps() {
    // either both the heaps will have equal number of elements or max-heap will have
    // one more element than the min-heap
    if (maxHeap.size() > minHeap.size() + 1)
      minHeap.add(maxHeap.poll());
    else if (maxHeap.size() < minHeap.size())
      maxHeap.add(minHeap.poll());
  }

  public static void main(String[] args) {
    SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
    double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
    System.out.print("Sliding window medians are: ");
    for (double num : result)
      System.out.print(num + " ");
    System.out.println();

    slidingWindowMedian = new SlidingWindowMedian();
    result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
    System.out.print("Sliding window medians are: ");
    for (double num : result)
      System.out.print(num + " ");
  }

}
