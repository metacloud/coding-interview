/*
Pattern: Sliding Window
00 Average of all subarrays of size K (easy)

Given an array, find the average of all subarrays of size 'K' in it.
*/

class AverageOfSubarrayOfSizeK {
  //Brute-Force
  public static double[] findAveragesInefficient(int K, int[] arr){
    double[] result = new double[arr.length-K+1];
    for(int i=0; i<arr.length-K+1; i++){
      double sum = 0;
      for(int j=i; j<i+K; j++){
        sum = sum + arr[j];
      }
      result[i] = (sum/K);
    }
    return result;
  }/*
  Time Complexity: O(N*K)
  */

  public static double[] findAverages(int K, int[] arr){
    double[] result = new double[arr.length - K +1];
    int startPoint = 0, endPoint = 0;

    double sum = 0.0;
    for(endPoint = 0; endPoint < arr.length; endPoint++){
      sum = sum + arr[endPoint];
      if(endPoint >= K-1){
        result[startPoint] = (sum/K);
        sum = sum - arr[startPoint];
        startPoint++;        
      }
    }
    return result;
  }/* 
  Time Complexity: O(N)
  */
} 
