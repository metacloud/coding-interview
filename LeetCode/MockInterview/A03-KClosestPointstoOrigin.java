/*
973. K Closest Points to Origin
*/


// 1. Using PriorityQueue, MaxHeap
class Solution {
    public int[][] kClosest(int[][] points, int K) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
        (a,b)->((b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1])));

        for(int[] point : points){
            maxHeap.offer(point);
            if(maxHeap.size()>K) maxHeap.poll();
        }

        int[][] result = new int[K][2];
        return maxHeap.toArray(result);
    }
}/*
Time Complexity: O(NlogK)
Space Complexity: The space complexity will be O(K) because we need to store ‘K’ point in the heap.

*/


// 2. Using Comparator
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return (a[0]*a[0]+a[1]*a[1]) - (b[0]*b[0]+b[1]*b[1]);
            }
        });
        return Arrays.copyOfRange(points,0,K);
    }
}/*
Time Complexity: O(NlogN)
Space Complexity:
*/
