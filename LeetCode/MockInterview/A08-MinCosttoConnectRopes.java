/*
Min Cost to Connect Ropes
*/

/*
Input: ropes = [8, 4, 6, 12]
Output: 58
Explanation: The optimal way to connect ropes is as follows
1. Connect the ropes of length 4 and 6 (cost is 10). Ropes after connecting: [8, 10, 12]
2. Connect the ropes of length 8 and 10 (cost is 18). Ropes after connecting: [18, 12]
3. Connect the ropes of length 18 and 12 (cost is 30).
Total cost to connect the ropes is 10 + 18 + 30 = 58
*/

public Solution {
    public int minCostConnectRopes(int[] ropes){
        int min = 0;
        if(ropes.length==0) return min;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int rope : ropes) minHeap.offer(rope);

        while(minHeap.size()>1){
            int curr = minHeap.poll()+minHeap.poll();
            min += curr;
            minHeap.offer(curr);
        }
        return min;
    }
}/*
Time Complexity: O(N*logN)
Space Complexity: O(N)
*/
