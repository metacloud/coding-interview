/*
Pattern: Sliding Window
02 Smallest Subarray with a given sum (easy)

Given an array of positive numbers and a positive number ‘S’,
find the length of the smallest subarray whose sum is greater than or equal to ‘S’.
Return 0, if no such subarray exists.
*/


class MinSizeSubArraySum {
  public static int findMinSubArray(int S, int[] arr) {
    int minLen = arr.length-1, Len = 0;
    int startSub = 0, endSub = 0;
    int sum = 0;

    for(endSub = 0; endSub < arr.length; endSub++){
        sum = sum + arr[endSub];
        Len++;

        while(sum >= S) {
            if(Len < minLen){
                minLen = Len;
            }
            sum = sum - arr[startSub];
            Len--;
            startSub++;
        }
    }
    return minLen;
  }

  public static void main(String[] args) {
    int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
    System.out.println("Smallest subarray length: " + result);
    result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
    System.out.println("Smallest subarray length: " + result);
    result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
    System.out.println("Smallest subarray length: " + result);
  }
}
/*
Time Complexity: O(N+N) For Loop + Inner While Loop ~= O(N)
Space Complexity: O(1)
*/
