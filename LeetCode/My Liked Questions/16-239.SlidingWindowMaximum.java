/*
239. Sliding Window Maximum
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || k<=0) return new int[0];
        int[] ret = new int[nums.length-k+1];

        Deque<Integer> q = new ArrayDeque<>(); // Index
        int index=0;
        for(int i=0; i<nums.length; i++){
            //remove element out of window
            if(!q.isEmpty() && q.peek() < i-k+1){ //0,1,2 i==3; 3-3+1=1 , remove index0
                q.poll();
            }

            //dq is decreasing number, remove smaller numbers ink range as they are useless
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]){
                q.pollLast();
            }

            q.offer(i); // make sure we add index! not value
            if(i >= k-1){ //i==2, 2-3+1 =0
                ret[index++] = nums[q.peek()];
            }

        }
        return ret;
    }
}
