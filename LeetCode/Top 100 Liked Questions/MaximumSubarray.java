/*
LeetCode 53. Maximum Subarray

[Result]
Runtime: 1 ms, faster than 89.30% of Java online submissions for Maximum Subarray.
Memory Usage: 38.2 MB, less than 97.06% of Java online submissions for Maximum Subarray.
*/

class Solution {
    public int maxSubArray(int[] nums) {
    	int currSum = nums[0], maxSum = nums[0];
        for(int i=1; i<nums.length; i++){
        	currSum = Math.max(currSum + nums[i], nums[i]);
        	maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}