/*
LeetCode 1. Two Sum

[Result]
Runtime: 2 ms, faster than 98.82% of Java online submissions for Two Sum.
Memory Usage: 38.4 MB, less than 80.43% of Java online submissions for Two Sum.
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            int pairVal = target - nums[i];
            if(hashmap.containsKey(pairVal)){
                return new int[] {hashmap.get(pairVal), i};
            }
            hashmap.put(nums[i],i);
        }
        return new int[] {-1, -1};
    }
}