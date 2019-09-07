/*
238. Product of Array Except Self
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];

        int left=1;
        ret[0] = 1;
        for(int i=1; i<nums.length; i++){
            left *= nums[i-1];
            ret[i] = left;
        }

        int right=1;
        for(int i=nums.length-2; i>=0; i--){
            right *= nums[i+1];
            ret[i] *= right;
        }
        return ret;
    }
}
