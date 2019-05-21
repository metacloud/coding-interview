
/*
Pattern: Sliding Window
01 Maximum Sum Subarray of Size K (easy)

Given an array of positive numbers and a positive number ‘k’,
find the maximum sum of any subarray of size ‘k’.
*/


class MaxSumSubArrayOfSizeK {
  public static int findMaxSumSubArray(int k, int[] arr) {
    int startSub = 0, endSub = 0, sum = 0, maxSum = 0;
    for(endSub = 0; endSub < arr.length; endSub++){
        sum = sum + arr[endSub];

      if(endSub >= k-1){
          if(sum > maxSum) maxSum = sum;
          sum -= arr[startSub];
          startSub++;
      }
    }
    return maxSum;
  }

  public static void main(String[] args) {
    System.out.println("Maximum sum of a subarray of size K: "
        + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
    System.out.println("Maximum sum of a subarray of size K: "
        + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
  }
}
/*
Time Complexity: O(N)
Space Complexity: O(1)
*/
