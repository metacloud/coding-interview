
/*
Pattern: Sliding Window
00 Average of all subarrays of size K (easy)

Given an array, find the average of all subarrays of size 'K' in it.
*/


import java.util.Arrays;

class AverageOfSubarrayOfSizeK {
  public static double[] findAverages(int K, int[] arr){

    double[] ret = new double[arr.length - K +1];
    double sum = 0;
    int startSub = 0;
    int endSub = 0;

    for(endSub = 0; endSub < arr.length; endSub++){
        sum = sum + arr[endSub];

        if(endSub >= K-1){
            ret[startSub] = (sum / K);
            sum = sum - arr[startSub];
            startSub++;
        }
    }
    return ret;
  }


  public static void main( String[] args){
    double[] result = AverageOfSubarrayOfSizeK.findAverages(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
    System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));

  }
} // Time Complexity: O(N)
