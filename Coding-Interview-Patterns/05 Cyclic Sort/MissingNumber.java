/*
Pattern: Cyclic Sort
02 Find the Missing Number (easy)

We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’.
Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.

# LeetCode 268. Missing Number [Easy]
[Result]
SUM >= XOR >= Cyclic Sort
*/

class MissingNumber {
  public int findMissingNumber(int[] nums) {
      int i=0;
      while(i < nums.length){
        if(nums[i] < nums.length && nums[i] != nums[nums[i]]){
          int correctIndex = nums[i];
          int temp = nums[i];
          nums[i] = nums[correctIndex];
          nums[correctIndex] = temp;
        } else {
          i++;
        }
      }
      for(i=0; i<nums.length; i++){
        if(nums[i] != i)
          return i;
      }
      return nums.length;
  }/*
  Time Complexity: O(N)
  Space Complexity: O(1)
  */

  public int findMissingNumber_SUM(int[] nums){
    int n = nums.length;
    int total = (n)*(n+1)/2;
    for(int i=0; i<nums.length; i++){
      total = total - nums[i];
    }
    return total;
  }/*
  Time Complexity: O(N)
  Space Complexity: O(1)
  */


  public int findMissingNumber_XOR(int[] nums){
    int ret = 0;
    for(int i=1; i<=nums.length; i++){
      ret = ret^i;
    }
    for(int i=0; i<nums.length; i++){
      ret = ret^nums[i];
    }
    return ret;
  }/*
  Time Complexity: O(N)
  Space Complexity: O(1)
  */
}
