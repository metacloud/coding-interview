/*
Pattern: Modified Binary Search
07 Bitonic Array Maximum (easy)

Find the maximum value in a given Bitonic array.
An array is considered bitonic if it is monotonically increasing and then monotonically decreasing.
Monotonically increasing or decreasing means that for any index i in the array arr[i] != arr[i+1].

# A Bitonic Sequence is a sequence of numbers which is first strictly increasing
then after a point strictly decreasing.

[Example]
Input: [1, 3, 8, 12, 4, 2]
Output: 12
Explanation: The maximum number in the input bitonic array is '12'.

*/

class MaxInBitonicArray {

  public static int findMax(int[] arr) {

    int start = 0, end = arr.length-1;
    while(start < end){
      int mid = start + (end-start)/2;

      if(arr[mid] > arr[mid+1]){ // we are in the descending part
        end = mid;
      }
      else{ // arr[mid] <= arr[mid+1] // we are in the ascending part
        start = mid+1;
      }
    }
    return arr[start];
  }/*
  Time Complexity: O(logN); since we are reducing the search range by half at every step.
  Space Complexity: O(1)
  */

  public static void main(String[] args) {
    System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12, 4, 2 }));
    System.out.println(MaxInBitonicArray.findMax(new int[] { 3, 8, 3, 1 }));
    System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12 }));
    System.out.println(MaxInBitonicArray.findMax(new int[] { 10, 9, 8 }));
  }
}
