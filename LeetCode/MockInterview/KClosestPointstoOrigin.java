/*
973. K Closest Points to Origin
*/


// 1. Using PriorityQueue, MaxHeap
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a,b)-> (Integer.compare(b[0]*b[0]+b[1]*b[1], a[0]*a[0]+a[1]*a[1]))
        );
        
        for(int i=0; i<K; i++){
            maxHeap.add(points[i]);
        }
        
        for(int i=K; i < points.length; i++){
            int[] max = maxHeap.peek();
            int curr = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            if(max[0]*max[0]+max[1]*max[1] > curr){
                maxHeap.poll();
                maxHeap.add(points[i]);
            }
        }
        
        int[][] result = new int[K][];
        return maxHeap.toArray(result);
    }
}

// 2. Using Quick Sort