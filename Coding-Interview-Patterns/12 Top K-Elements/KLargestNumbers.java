/*
Pattern: Top 'K' Elements
01 Top 'K' Numbers (easy)

Given an unsorted array of numbers, find the ‘K’ largest numbers in it.
Note: For a detailed discussion about different approaches to solve this problem, take a look at Kth Smallest Number.

Example 1: Input: [3, 1, 5, 12, 2, 11], K = 4
           Output: [3, 11, 5 ,12]
Example 2: Input: [5, 12, 11, -1, 12], K = 3
           Output: [12, 11, 12]
*/

import java.util.*;

class KLargestNumbers {
  public static List<Integer> findKLargestNumbers(int[] nums, int k){
    //minHeap
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    for(int i=0; i<k; i++){
      minHeap.add(nums[i]);
    }

    for(int i=k; i<nums.length; i++){
      if(minHeap.peek() < nums[i]){
        minHeap.poll();
        minHeap.add(nums[i]);
      }
    }
    return new ArrayList<>(minHeap);
  }/*
  Time Complexity: O(K + (N-K)*logK) ( better than O(N*logN) )
  Space Complexity: O(K)
  */


  public static void main(String[] args) {
      List<Integer> result = KLargestNumbers.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
      System.out.println("Here are the top K numbers: " + result);

      result = KLargestNumbers.findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
      System.out.println("Here are the top K numbers: " + result);
  }
}
