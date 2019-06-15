
/*
Pattern: Cyclic Sort
04 Find the Duplicate Number (easy)

We are given an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’.
The array has only one duplicate but it can be repeated multiple times.
Find that duplicate number without using any extra space.
You are, however, allowed to modify the input array though.

Input: [1, 4, 4, 3, 2]
Output: 4
Input: [2, 4, 1, 4, 4]
Output: 4

# LeetCode 287. Find the Duplicate Number [Medium]
[Result]
Runtime: 1 ms, faster than 59.94% of Java online submissions for Find the Duplicate Number.
Memory Usage: 37.5 MB, less than 39.60% of Java online submissions for Find the Duplicate Number.
*/

import java.util.Arrays;

class FindDuplicate {
  public static int findNumber(int[] nums){
    int i=0;
    while(i<nums.length){
      if(i != nums[i]-1){
        int correctIndex = nums[i]-1;
        int temp = nums[i];
        if(nums[i] == nums[correctIndex]) return nums[i];
        else {
          nums[i] = nums[correctIndex];
          nums[correctIndex] = temp;
        }
      }
      else {
        i++;
      }
    }
    return -1;
  }/*
  Time Complexity: O(n)
  Space Complexity: O(1)
  */

  public static void main(String[] args){
    System.out.println(FindDuplicate.findNumber(new int[] { 1, 4, 4, 3, 2 }));
    System.out.println(FindDuplicate.findNumber(new int[] { 2, 1, 3, 3, 5, 4 }));
    System.out.println(FindDuplicate.findNumber(new int[] { 2, 4, 1, 4, 4 }));
  }
}
