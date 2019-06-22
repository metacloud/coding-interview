
/*
Pattern: K-way merge
03 Kth Smallest Number in a Sorted Matrix (Hard)

Given an N * N matrix where each row and column is sorted in ascending order,
find the Kth smallest element in the matrix.

Input:
Matrix=[
         [2, 6, 8],
         [3, 7, 10],
         [5, 8, 11]
      ],
K=5
Output: 7
Explanation: The 5th smallest number in the matrix is 7.

# LeetCode 378. Kth Smallest Element in a Sorted Matrix [Medium]
[Result]
Runtime: 48 ms, faster than 17.04% of Java online submissions for Kth Smallest Element in a Sorted Matrix.
Memory Usage: 44.2 MB, less than 60.35% of Java online submissions for Kth Smallest Element in a Sorted Matrix.
*/

import java.util.*;

class Node {
    int row;
    int col;
    Node(int row, int col){
      this.row = row;
      this.col = col;
    }
}

// Solution : Heap
class KthSmallestInSortedMatrix {
  public static int findKthSmallest(int[][] matrix, int k){
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>(
        (a,b) -> (matrix[a.row][a.col] - matrix[b.row][b.col])
        );

        for(int i=0; i<matrix.length && i <k; i++){
            minHeap.add(new Node(i,0));
        }

        int count = 0, result = 0;
        while(!minHeap.isEmpty()){
            Node tp = minHeap.poll();
            result = matrix[tp.row][tp.col];

            if(++count == k) break;
            tp.col++;
            if(matrix[tp.row].length > tp.col){
                minHeap.add(tp);
            }
        }
        return result;
    }/*
    Time Complexity: we inserted at most K or one element from each of the N rows,
    which will take O(min(K,N)). Then we went through at most K elements in the Matrix
    and remove/add one element in the heap in each step. As we can't have more than N elements
    in the heap in any condition, therefore, the overall time Complexity will be
    O(min(K,N)+ K*logN);

    Space Complexity: O(N), in the worst case, our min-heap will be storing one number from
    each of the 'N' rows.
    */

  public static void main(String[] args){
    int matrix[][] = {{2, 6, 8}, {3, 7, 10}, {5, 8, 11}};
    int result = KthSmallestInSortedMatrix.findKthSmallest(matrix, 5);
    System.out.print("Kth smallest number is : " + result);
  }
}
