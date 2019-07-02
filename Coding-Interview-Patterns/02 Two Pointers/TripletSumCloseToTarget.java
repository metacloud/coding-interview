/*
Pattern: Two Pointers
05 Triplet Sum Close to Target (medium)

Given an array of unsorted numbers and a target number,
find a triplet in the array whose sum is as close to the target number as possible.

Input: [-2, 0, 1, 2], target=2
Output: 1
Explanation: The triplet [-2, 1, 2] has the closest sum to the target.

# LeetCode 16. 3Sum Closest [Medium]
Runtime: 4 ms, faster than 96.24% of Java online submissions for 3Sum Closest.
Memory Usage: 36.6 MB, less than 99.97% of Java online submissions for 3Sum Closest.

*/
import java.util.*;

class TripletSumCloseToTarget {

  public static int searchTriplet(int[] arr, int targetSum) {

    Arrays.sort(arr);
    int smallestDiff = Integer.MAX_VALUE;
    for(int i=0; i<arr.length-2; i++){
      int x = i+1, y = arr.length-1;

      while(x < y){

        int currDiff = targetSum - arr[i] - arr[x] - arr[y];
        if(currDiff == 0){
          return targetSum - currDiff;
        }
        if(Math.abs(currDiff) < Math.abs(smallestDiff)){
          smallestDiff = currDiff;
        }
        if(currDiff > 0){ // we need bigger sum
          x++;
        }
        else { // currDiff < 0 , we need smaller sum
          y--;
        }
      }
    }
    return targetSum - smallestDiff;
}/*
Time Complexity: O(N*logN + N^2) => O(N^2)
Space Complexity: O(N) which is required for sorting.
*/

  public static void main(String[] args){
    System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
    System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
    System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
  }
}
