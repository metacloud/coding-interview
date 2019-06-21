/*
Pattern: Top 'K' Elements
04 Connect Ropes (easy)

Given ‘N’ ropes with different lengths, we need to connect these ropes into one big rope with minimum cost.
The cost of connecting two ropes is equal to the sum of their lengths.

[ Example ]
Input: [1, 3, 11, 5]
Output: 33
Explanation: First connect 1+3(=4), then 4+5(=9), and then 9+11(=20). So the total cost is 33 (4+9+20)
*/


import java.util.*;

class ConnectRopes {
  public static int minimumCostToConnectRopes(int[] ropeLengths){

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for(int ropeLen : ropeLengths){
      minHeap.add(ropeLen);
    }

    int minCost = 0, currentMin = 0;
    while(!minHeap.isEmpty()){
      currentMin = minHeap.poll() + minHeap.poll();
      minCost += currentMin;

      if(minHeap.isEmpty()) {
        return minCost;
      } else {
         minHeap.add(currentMin);
      }
    }
    return minCost;
  }/*
  Time Complexity: O(N*logN)
  Space Complexity: O(N)
  */

  public static void main(String[] args){
    int result = ConnectRopes.minimumCostToConnectRopes(new int[] {1,3,11,5});
    System.out.println("Minimum cost to connect ropes: " + result );
    result = ConnectRopes.minimumCostToConnectRopes(new int[] {1, 3, 11, 5, 2});
    System.out.println("Minimum cost to connect ropes: " + result);
  }
}
