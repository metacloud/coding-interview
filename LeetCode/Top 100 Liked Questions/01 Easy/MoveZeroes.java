/*
LeetCode 283. Move Zeroes

[Result]
Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
Memory Usage: 38.3 MB, less than 78.64% of Java online submissions for Move Zeroes.
*/

class Solution {
    public void moveZeroes(int[] nums) {
        int start = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[start];
                nums[start] = temp;
                start++;
            }
        }
    }/*
    Time Complexity: O(N)
    Space Complexity: O(1)
    */
}