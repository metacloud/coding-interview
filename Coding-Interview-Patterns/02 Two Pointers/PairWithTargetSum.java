
/*
Pattern: Two Pointers
01 Pair with Target Sum (easy)

Given an array of sorted numbers and a target sum,
find a pair in the array whose sum is equal to the given target
Write a function to return the indices of the two numbers (i.e. the pair)
such that they add up to the given target.
*/

import java.util.HashMap;

class PairWithTargetSum {
  //Two-Pointers
  public static int[] search(int[] arr, int targetSum) {
    int start = 0, end = (arr.length-1);

    while(start < end){
      if(arr[start]+arr[end] < targetSum) start++;
      else if(arr[start]+arr[end] > targetSum) end--;
      else return new int[] {start, end};
    }
    return new int[] {-1,-1};
  }/*
  Time Complexity: O(N)
  Space Complexity: O(1)
  */


  //Hash-Table
  public static int[] searchHash(int[] arr, int targetSum){
    HashMap<Integer,Integer> target = new HashMap<Integer, Integer>();
    for(int i=0; i < arr.length; i++){
      if(target.containsKey(targetSum - arr[i])){
        int getPair = target.get(targetSum-arr[i]);
        return new int[] {getPair, i};
      } else {
        target.put(arr[i], i);
      }
    }
    return new int[] {-1, -1};
  }/*
  Time Complexity: O(N)
  Space Complexity: O(N)
  */

  public static void main(String[] args) {
    int[] result = PairWithTargetSum.search(new int[] { 1, 2, 3, 4, 6 }, 6);
    System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    result = PairWithTargetSum.search(new int[] { 2, 5, 9, 11 }, 11);
    System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    result = PairWithTargetSum.searchHash(new int[] { 1, 2, 3, 4, 6 }, 6);
    System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    result = PairWithTargetSum.searchHash(new int[] { 2, 5, 9, 11 }, 11);
    System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
  }
}
