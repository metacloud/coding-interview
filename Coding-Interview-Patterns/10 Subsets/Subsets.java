/*
Pattern: Subsets
01 Subsets (easy)

Given a set with distinct elements, find all of its distinct subsets.

# LeetCode 78. Subsets [Medium]
[Result]
Runtime: 0 ms, faster than 100.00% of Java online submissions for Subsets.
Memory Usage: 36.6 MB, less than 98.93% of Java online submissions for Subsets.
*/


import java.util.*;

class Subsets {
  public static List<List<Integer>> findSubsets(int[] nums){
    List<List<Integer>> subsets = new ArrayList<>();

    //add EmptySet
    subsets.add(new ArrayList<>());
    for(int num : nums){
        int n = subsets.size();
        for(int i=0; i<n; i++){
            List<Integer> set = new ArrayList<>(subsets.get(i));
            set.add(num);
            subsets.add(set);
        }
    }
    return subsets;
  }/*
  Time Complexity: O(2^N)
  ; since each step, the number of subsets doubles as we add each element to all
  the existing subsets.

  Space Complexity: O(2^N)
  ; all the additional space used is for the output list.
  */

  public static void main(String[] args) {
    List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
    System.out.println("Here is the list of subsets: " + result);

    result = Subsets.findSubsets(new int[] { 1, 5, 3 });
    System.out.println("Here is the list of subsets: " + result);
  }
}
