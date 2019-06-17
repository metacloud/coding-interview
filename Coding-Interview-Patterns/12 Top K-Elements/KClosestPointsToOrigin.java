/*
Pattern: Top 'K' Elements
03 'K' Closest Points to the Origin (easy)

Given an array of points in the a 2D2D plane, find ‘K’ closest points to the origin.

Input: points = [[1,2],[1,3]], K = 1
Output: [[1,2]]
Explanation: The Euclidean distance between (1, 2) and the origin is sqrt(5).
The Euclidean distance between (1, 3) and the origin is sqrt(10).
Since sqrt(5) < sqrt(10), therefore (1, 2) is closer to the origin.

# LeetCode 973. K Closest Points to Origin [Medium]
[Result]
Runtime: 52 ms, faster than 41.25% of Java online submissions for K Closest Points to Origin.
Memory Usage: 64.5 MB, less than 15.93% of Java online submissions for K Closest Points to Origin.
*/

import java.util.*;

class Point {
  int x;
  int y;

  public Point(int x, int y){
    this.x = x;
    this.y = y;
  }

  public int distFromOrigin(){
    return (x*x)+(y*y);
  }
};

class KClosestPointsToOrigin {
  public static List<Point> findClosestPoints(Point[] points, int k){

    //define maxHeap
    PriorityQueue<Point> maxHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.distFromOrigin(), p1.distFromOrigin()));

    for(int i=0; i<k; i++){
      maxHeap.add(points[i]);
    }

    for(int i=k; i<points.length; i++){
      if(points[i].distFromOrigin() < maxHeap.peek().distFromOrigin()){
        maxHeap.poll();
        maxHeap.add(points[i]);
      }
    }
    return new ArrayList<>(maxHeap);
  }/*
  Time Complexity: k + (n-k) * log(k)
  Space Complexity: O(k);
  */

  public static void main(String[] args){
    Point[] points = new Point[] { new Point(1, 3), new Point(3, 4), new Point(2, -1) };
    List<Point> result = KClosestPointsToOrigin.findClosestPoints(points, 2);
    System.out.print("Here are the k points closest the origin: ");
    for(Point p : result){
      System.out.print("[" + p.x + " , " + p.y + "] ");
    }
  }
}


//LeetCode : Input type "2D Arrays"
class Solution {
    public int[][] kClosest(int[][] points, int K){

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
        (a,b)->Integer.compare(b[0]*b[0]+b[1]*b[1], a[0]*a[0]+a[1]*a[1]));

        for(int i=0; i<K; i++){
            maxHeap.add(points[i]);
        }

        for(int i=K; i<points.length; i++){
            int[] max = maxHeap.peek();
            if(max[0]*max[0]+max[1]*max[1] > points[i][0]*points[i][0] + points[i][1]*points[i][1]){
                   maxHeap.poll();
                   maxHeap.add(points[i]);
               }
        }
        int[][] KClosests = new int[maxHeap.size()][];
        return maxHeap.toArray(KClosests);
      }
}
