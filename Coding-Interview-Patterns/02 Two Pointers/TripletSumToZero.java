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
Runtime: 28 ms, faster than 92.78% of Java online submissions for 3Sum.
Memory Usage: 46.7 MB, less than 93.41% of Java online submissions for 3Sum.
*/

import java.util.*;

class TripletSumToZero {

  public static List<List<Integer>> threeSum(int[] nums) {

      List<List<Integer>> threePair = new ArrayList<>();

      Arrays.sort(nums);
      for(int i = 0; i < nums.length-2; i++){
          if( i > 0 && nums[i] == nums[i-1]){
              continue;
          }
          getPairs(nums, nums[i], i+1, threePair);
      }
      return threePair;
  }

    private static void getPairs(int[] nums, int targetSum, int left, List<List<Integer>> threePair){
         int right = nums.length-1;

         while(left < right){
             //targetSum(a) + b + c = 0
             // b + c = -targetSum(a)
             // c(right) = -targetSum(a) - b(left)
             int target = -targetSum - nums[left];

             if(target == nums[right] ){
                 //we found it!
                 threePair.add(Arrays.asList(targetSum, nums[left], nums[right]));
                 //update left & right, we may have different unique pair has same targetSum.
                 left++;
                 right--;
                 while(left < right && nums[left] == nums[left-1]){
                     left++;
                 }
                 while(left < right && nums[right] == nums[right + 1]){
                     right--;
                 }
             }

             else if( target > nums[right]){
                 left++;
             }
             else { // target < nums[right]
                 right--;
             }
         }
     }

  public static void main(String[] args) {
    System.out.println(TripletSumToZero.threeSum(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
    System.out.println(TripletSumToZero.threeSum(new int[] { -5, 2, -1, -2, 3 }));
  }
}
