/*
LeetCode 169. Majority Element

[Result]
Runtime: 2 ms, faster than 54.39% of Java online submissions for Majority Element.
Memory Usage: 42.7 MB, less than 54.80% of Java online submissions for Majority Element.
*/


class Solution { // Sorting
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}/*
Time Complexity: O(NlogN)
Space Complexity: O(1) or O(N) if we are not able to sort nums in place.
*/

class Solution { // HashMap
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            hashmap.put(nums[i], hashmap.getOrDefault(nums[i],0)+1);
            if(hashmap.get(nums[i]) > nums.length/2){
                return nums[i];
            }
        }
        return -1;
    }
}/*
Time Complexity: O(N)
Space Complexity: O(N)
*/