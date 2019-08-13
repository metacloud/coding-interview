/*
Find Pair With Given Sum

Given an array of integers nums and an int target, return indices of the two numbers such that they add up to a target - 30.

Conditions:

You will pick exactly 2 numbers.
You cannot pick the same element twice.
If you have muliple pairs, select the pair with the largest number.
*/

class Solution {
    public static int[] findPair(int[] nums, int target){
        if(nums==null || nums.length==0) return new int[]{-1,-1};

        target = target-30;
        Map<Integer, Integer> map = new HashMap<>(); // (nums[i], i) pair
        int[] ret = {-1,-1};
        for(int i=0; i<nums.length; i++){
            int pairVal = target - nums[i];
            if(map.containsKey(pairVal)){
                if(ret[0]==-1){
                    ret[0] = map.get(pairVal);
                    ret[1] = i;
                }
                else if(Math.max(nums[i], pairVal) > Math.max(nums[ret[0]], nums[ret[1]])) {
                    //we already found pair earlier
                    ret[0] = map.get(pairVal);
                    ret[1] = i;
                }
            }
            else {
                map.put(nums[i], i);
            }
        }
        return ret;
    }
}
