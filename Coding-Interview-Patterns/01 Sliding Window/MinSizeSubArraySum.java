/*
Pattern: Sliding Window
02 Smallest Subarray with a given sum 

Given an array of positive numbers and a positive number ‘S’,
find the length of the smallest subarray whose sum is greater than or equal to ‘S’.
Return 0, if no such subarray exists.

# LeetCode 209. Minimum Size Subarray Sum [Medium]
[Result]
Runtime: 1 ms, faster than 99.97% of Java online submissions for Minimum Size Subarray Sum.
Memory Usage: 35.6 MB, less than 99.92% of Java online submissions for Minimum Size Subarray Sum.
*/

// Dont forget to check Base & Edge Cases!
class MinSizeSubArraySum {
  public static int findMinSubArray(int S, int[] arr) {
    if(arr.length == 0) return 0;

    int startPoint = 0, endPoint = 0;
    int minLen = Integer.MAX_VALUE, sum = 0;   
    for(endPoint = 0; endPoint < arr.length; endPoint++){
        sum = sum + arr[endPoint];
        while(sum >= S) {
            minLen = Math.min(minLen, endPoint-startPoint+1);
            sum = sum - arr[startPoint];
            startPoint++;
        }
    }
    // Sum of all elements < S; (= No subarray >= S)
    if(minLen == Integer.MAX_VALUE) return 0;
    return minLen;
  }/*
    Time Complexity: O(N)
    Space Complexity: O(1)
    */
}

