
/*
Pattern: Sliding Window
00 Average of all subarrays of size K (easy)

Given an array, find the average of all subarrays of size 'K' in it.
*/


import java.util.Arrays;

class AverageOfSubarrayOfSizeK {
  //Brute-Force
  public static double[] findAveragesInefficient(int K, int[] arr){
    double[] ret = new double[arr.length-K+1];
    for(int i=0; i<=arr.length-K; i++){
      double sum = 0;
      for(int j=i; j<i+K; j++){
        sum = sum + arr[j];
      }
      ret[i] = sum/K;
    }
    return ret;
  }/*
  Time Complexity: O(N*K)
  */

  public static double[] findAverages(int K, int[] arr){

    double[] ret = new double[arr.length - K +1];
    double sum = 0;
    int startSub = 0;
    int endSub = 0;

    for(endSub = 0; endSub < arr.length; endSub++){
        sum = sum + arr[endSub];

        if(endSub >= K-1){
            ret[startSub] = (sum / K);
            sum = sum - arr[startSub]; //reset sum=0;
            startSub++;
        }
    }
    return ret;
  }/*
  Time Complexity: O(N)
  */


  public static void main( String[] args){

    double[] result = AverageOfSubarrayOfSizeK.findAveragesInefficient(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
    System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
    result = AverageOfSubarrayOfSizeK.findAverages(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
    System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));

  }
} // Time Complexity: O(N)
