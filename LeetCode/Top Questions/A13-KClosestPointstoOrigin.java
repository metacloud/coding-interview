/*
973. K Closest Points to Origin
*/

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        //K Closest => PriorityQueue
        int[][] ret = new int[K][2];
        if(points==null || points.length==0 || points[0].length==0) return ret;


        //maxHeap
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] p1, int[] p2){
                return (p2[0]*p2[0]+p2[1]*p2[1])-(p1[0]*p1[0]+p1[1]*p1[1]);
            }
        });

        for(int[] point : points){
            pq.offer(point);
            if(pq.size()>K) pq.poll();
        }

        return pq.toArray(ret);
    }
}
/*
Time Complexity: O(NlogK), N is the length of points, logK is for Heap, Insersion/Remove Max/Min
Space Complexity: O(K) for Heap
*/

class Solution {
    public int[][] kClosest(int[][] points, int K) {

        Arrays.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int[] p1, int[] p2){
                return (p1[0]*p1[0]+p1[1]*p1[1])-(p2[0]*p2[0]+p2[1]*p2[1]);
            }
        });
        return Arrays.copyOfRange(points, 0, K);
    }
}
/*
Time Complexity: O(NlogN)
Space Complexity: O(1), sorting part don't count for extra space.
*/
