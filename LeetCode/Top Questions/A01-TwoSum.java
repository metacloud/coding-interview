/*
1. Two Sum
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        //value-Index pair
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                return new int[] {map.get(target-nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[] {-1,-1};
    }
}
/*
Exact Two Sum Pair => HashMap
Time Complexity: O(N)
Space Complexity: O(N) required for HashMap
*/
