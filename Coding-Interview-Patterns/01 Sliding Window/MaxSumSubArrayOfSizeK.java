/*
Pattern: Sliding Window
01 Maximum Sum Subarray of Size K (easy)

Given an array of positive numbers and a positive number ‘k’,
find the maximum sum of any subarray of size ‘k’.

[Example]
Input: [2, 1, 5, 1, 3, 2], k=3
Output: 9
*/

class MaxSumSubArrayOfSizeK {
  public static int findMaxSumSubArray(int k, int[] arr) {
    int sum = 0, maxSum = 0;
    int startPoint, endPoint = 0;
    for(endPoint = 0; endPoint < arr.length; endPoint++) {
      sum = sum + arr[endPoint];
      if(endPoint >= k-1){
        maxSum = Math.max(sum, maxSum);
        sum = sum - arr[startPoint];
        startPoint++;
      }
    }
    return maxSum;
  }
}/*
Time Complexity: O(N)
Space Complexity: O(1)
*/
