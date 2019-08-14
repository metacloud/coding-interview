/*
581. Shortest Unsorted Continuous Subarray
*/


public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int start =-1;
        int end = -1;
        int max = nums[0];
        int min = nums[nums.length-1];

        //find startPoint
        for(int i=1;i<nums.length;i++){
            if(nums[i]<max){
                end = i;
            }
            max = Math.max(max,nums[i]);
        }
        //find endPoint
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>min){
                start = i;
            }
            min = Math.min(min,nums[i]);
        }
        if (start == -1 && end == -1) return 0;
        return (end - start + 1);
    }
}
