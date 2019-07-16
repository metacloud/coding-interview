/*
Pattern: Two Pointers
01 Pair with Target Sum (easy)

Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target
Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.

[Example]
Input: [1, 2, 3, 4, 6], target=6
Output: [1, 3]
Explanation: The number at index 1 and 3 add up to 6: 2+4=6
*/
import java.util.HashMap;

class PairWithTargetSum {
  //Two-Pointers
  public static int[] search(int[] arr, int targetSum) {
    int start = 0, end = (arr.length-1);
    int currSum = 0;

    while(start < end){
      currSum = arr[start] + arr[end];
      if(currSum == targetSum){
        return new int[] {start, end};
      }
      else if(currSum < targetSum){
        start++;
      }
      else { //currSum > targetSum
        end--;
      }
    }
    return new int[] {-1,-1};
  }/*
  Time Complexity: O(N)
  Space Complexity: O(1)
  */

  //Hash-Table
  public static int[] searchHash(int[] arr, int targetSum){
    HashMap<Integer,Integer> hashmap = new HashMap<Integer, Integer>();
    for(int i=0; i < arr.length; i++){
      int target = targetSum - arr[i];
      if(hashmap.containsKey(target)){
        return new int[] {hashmap.get(target), i};
      } else {
        hashmap.put(arr[i], i);
      }
    }
    return new int[] {-1, -1};
  }/*
  Time Complexity: O(N)
  Space Complexity: O(N); pushing N numbers in the HashTable.
  */
}
