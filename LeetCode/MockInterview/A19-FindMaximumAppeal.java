/*
Find Pair with Max Appeal
*/

/*
Input: {1, 3, -1}
output: {1, 1}
Appeal = arr[1] + arr[1] + abs(0) = 6

Input : Array
Output : index {i, j} (i = j allowed) with maximum Appeal
Appeal = arr[i] +arr[j] + abs(i-j)

arr[i]+arr[j]+abs(i-j)  =  1. arr[i]+arr[j] +(i-j) = (arr[i]+i) + (arr[j]-j)
                           2. arr[i]+arr[j] -(i-j) = (arr[i]-i) + (arr[j]+j)
*/

class Solution {
    public int[] maxAppealPair(int[] arr){
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        int ret1=-1, ret2=-1;
        for(int i=0; i<arr.length; i++){
            int val1 = arr[i]+i;
            int val2 = arr[i]-i;

            if(val1 > max1){
                max1 = Math.max(max1, val1);
                ret1 = i;
            }
            if(val2 > max2){
                max2 = Math.max(max2, val2);
                ret2 = i;
            }
        }
        return new int[] {ret1,ret2};
    }
}/*
Time Complexity: O(N)
Space Complexity: O(1)
*/
