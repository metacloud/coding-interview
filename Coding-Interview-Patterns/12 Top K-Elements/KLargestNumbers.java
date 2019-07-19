/*
Pattern: Top 'K' Elements
01 Top 'K' Numbers (easy)

Given an unsorted array of numbers, find the ‘K’ largest numbers in it.
Note: For a detailed discussion about different approaches to solve this problem, take a look at Kth Smallest Number.

Input: [3, 1, 5, 12, 2, 11], K = 4
Output: [3, 11, 5 ,12]
/*
Brute force Solution: sorting the array and then return the largest K numbers.
Time Complexity: O(NlogN)
*/

class KLargestNumbers {
  public List<Integer> findKLargestNumbers(int[] nums, int k){
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
}
