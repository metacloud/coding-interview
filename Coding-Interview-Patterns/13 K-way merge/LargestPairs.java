
/*
Pattern: K-way merge
05 K Pairs with Largest Sums (Hard)

Given two sorted arrays in descending order,
find ‘K’ pairs with the largest sum where each pair consists of numbers from both the arrays.

Input: L1=[9, 8, 2], L2=[6, 3, 1], K=3
Output: [9, 3], [9, 6], [8, 6]
Explanation: These 3 pairs have the largest sum. No other pair has a sum larger than any of these.
*/


import java.util.*;

class LargestPairs {

  public static List<int[]> findKLargestPairs(int[] nums1, int[] nums2, int k) {
    PriorityQueue<int[]> minHeap = new PriorityQueue<>(
      (a,b) -> ((a[0]+a[1])-(b[0]+b[1]))
    );

    for(int i=0; i<nums1.length && i<k; i++){
      for(int j=0; j<nums2.length && j<k; j++){
        if(minHeap.size() < k){
          minHeap.add(new int[] {nums1[i], nums2[j]});
        } else { //minHeap.size > k
          if(nums1[i]+nums2[j] < minHeap.peek()[0] + minHeap.peek()[1]){
            break;
          } else {
            minHeap.poll();
            minHeap.add(new int[] {nums1[i], nums2[j]});
          }
        }
      }
    }
    return new ArrayList<>(minHeap);
  }/*
  Time Complexity: O(N * M * logK) => O(K^2 * logK)
  Because at most we will be going through all the elements of both arrays and we will add/remove one element in the heap in each step,
  the time complexity of the algorithm will be O(N * M * logK) where ‘N’ and ‘M’ are the total number of elements in both arrays, respectively.
  If we assume that both arrays have at least K elements then the time complexity can be simplified to O(K^2 * logK)
  because we are not iterating more than ‘K’ elements in both arrays.

  Space Complexity: O(K), Min Heap will be storing K largest pairs.
  */

  public static void main(String[] args) {
    int[] l1 = new int[] { 9, 8, 2 };
    int[] l2 = new int[] { 6, 3, 1 };
    List<int[]> result = LargestPairs.findKLargestPairs(l1, l2, 3);
    System.out.print("Pairs with largest sum are: ");
    for (int[] pair : result)
      System.out.print("[" + pair[0] + ", " + pair[1] + "] ");
  }
}
