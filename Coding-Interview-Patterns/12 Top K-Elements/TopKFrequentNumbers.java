/*
Pattern: Top 'K' Elements
05 Top 'K' Frequent Numbers (medium)

Given an unsorted array of numbers, find the top ‘K’ frequently occurring numbers in it.

[Example]
Input: [1, 3, 5, 12, 11, 12, 11], K = 2
Output: [12, 11]
Explanation: Both '11' and '12' apeared twice.

# LeetCode 347. Top K Frequent Elements
[Result]
Runtime: 49 ms, faster than 8.64% of Java online submissions for Top K Frequent Elements.
Memory Usage: 40.4 MB, less than 56.69% of Java online submissions for Top K Frequent Elements.

*/

import java.util.*;

class TopKFrequentNumbers {

  public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
    List<Integer> topNumbers = new ArrayList<>(k);

    HashMap<Integer, Integer> hashmap = new HashMap<>();
    for(int num : nums){
      hashmap.put(num, hashmap.getOrDefault(num,0)+1);
    }

    PriorityQueue<Integer> minHeap = new PriorityQueue<>(
    (a,b)->(hashmap.get(a) - hashmap.get(b))
    );

    for(int n : hashmap.keySet()){
      minHeap.add(n);
      if(minHeap.size() > k){
        minHeap.poll();
      }
    }

    while(!minHeap.isEmpty()){
      topNumbers.add(minHeap.poll());
    }

    Collections.reverse(topNumbers);
    return topNumbers;
  }/*
  Time Complexity: O(N*logk)
  Space Complexity: O(N)
  */


  public static void main(String[] args) {
    List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
    System.out.println("Here are the K frequent numbers: " + result);

    result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
    System.out.println("Here are the K frequent numbers: " + result);
  }
}
