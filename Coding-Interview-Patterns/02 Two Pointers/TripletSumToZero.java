/*
Pattern: Two Pointers
04 Triplet Sum to Zero (medium)

Given an array of unsorted numbers, find all unique triplets in it that add up to zero.

[Example]
Input: [-3, 0, 1, 2, -1, 1, -2]
Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
Explanation: There are four unique triplets whose sum is equal to zero.

# LeetCode 15. 3Sum
[Result]

*/


import java.util.*;

class TripletSumToZero { // -3 -2 -1 1 0 1 2

  public static List<List<Integer>> searchTriplets(int[] arr) {
    List<List<Integer>> result = new ArrayList<>();

    Arrays.sort(arr);
    for(int left = 0; left < arr.length - 2; left++){
      if(left > 0 && arr[left] == arr[left-1]){
        continue;
      }
      // x + y + z == 0 <=> y+z = -x : -arr[left]
      searchPair(arr, -arr[left], left+1, result);
    }
    return result;
  }

  private static void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> result){
      int right = arr.length-1;
      while(left < right){
        int targetDiff = targetSum - arr[left];
        if(targetDiff == arr[right]){
          //we found it!
          result.add(Arrays.asList(-targetSum, arr[left], arr[right]));
          left++;
          right--;
          while(left < right && arr[left] == arr[left-1]){
            left++;
          }
          while(left < right && arr[right] == arr[right+1]){
            right--;
          }
        }
        else if(targetDiff > arr[right]){
          left++;
        }
        else {
          //targetDiff < arr[right]
          right--;
        }
      }
  }



  public static void main(String[] args) {
    System.out.println(TripletSumToZero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
    System.out.println(TripletSumToZero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
  }
}
