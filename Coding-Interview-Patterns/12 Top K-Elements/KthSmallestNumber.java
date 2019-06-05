/*
Pattern: Top 'K' Elements
02 Kth Smallest Number (easy)

Given an unsorted array of numbers, find Kth smallest number in it.
Please note that it is the Kth smallest number in the sorted order, not the Kth distinct element.
Note: For a detailed discussion about different approaches to solve this problem, take a look at Kth Smallest Number.

[ Example ]
Input: [1, 5, 12, 2, 11, 5], K = 3
Output: 5
Explanation: The 3rd smallest number is '5', as the first two smaller numbers are [1, 2].
*/

import java.util.*;

class KthSmallestNumber {
      public static int findKthSmallestNumber(int[] nums, int k){
        //maxHeap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->Integer.compare(b,a));

        for(int i=0; i<k; i++){
          maxHeap.add(nums[i]);
        }

        for(int i=k; i<nums.length; i++){
          if(maxHeap.peek() > nums[i]){
            maxHeap.poll();
            maxHeap.add(nums[i]);
          }
        }
        return maxHeap.peek();
      }/*
      Time Complexity: O(K + (N-K)*logK)
      Space Complexity: O(K)
      */

      /*
      Alternate Solution : we can use a Min Heap to find the Kth smallest number.
      we are able to insert all the numbers in the min-heap, then get the top 'K' Numbers
      from the heap to find the Kth smallest number.
      -Inserting all numbers in the heap : O(N)
      -Extracting 'K' numbers : O(KlogN)
      : Time Complexity: O(N+KlogN)
      : Space Complexity: O(N)
      */

      public static void main(String[] args) {
      int result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
      System.out.println("Kth smallest number is: " + result);

      // since there are two 5s in the input array, our 3rd and 4th smallest numbers should be a '5'
      result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
      System.out.println("Kth smallest number is: " + result);

      result = KthSmallestNumber.findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
      System.out.println("Kth smallest number is: " + result);
    }

}
