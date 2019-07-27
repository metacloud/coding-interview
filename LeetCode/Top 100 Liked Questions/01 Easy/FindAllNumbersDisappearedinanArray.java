/*
LeetCode 448. Find All Numbers Disappeared in an Array

[Result]
Runtime: 6 ms, faster than 80.16% of Java online submissions for Find All Numbers Disappeared in an Array.
Memory Usage: 47.5 MB, less than 94.35% of Java online submissions for Find All Numbers Disappeared in an Array.
*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums.length==0) return result;
        
        int i=0;
        while(i<nums.length){
            if(nums[i] != i+1 && nums[i] != nums[nums[i]-1]){
                int correctIndex = nums[i]-1;
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }

        for(i=0; i<nums.length; i++){
            if(nums[i] != i+1){
                result.add(i+1);
            }
        }
        return result;
    }
}
