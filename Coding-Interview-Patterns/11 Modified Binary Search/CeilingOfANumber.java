/*
Pattern: Modified Binary Search
02 Ceiling of a Number (medium)

Given an array of numbers sorted in an ascending order, find the ceiling of a given number ‘key’.
The ceiling of the ‘key’ will be the smallest element in the given array greater than or equal to the ‘key’.
Write a function to return the index of the ceiling of the ‘key’. If there isn’t any ceiling return -1.
*/

class CeilingOfANumber {

  public static int searchCeilingOfANumber(int[] arr, int key){
    if(arr[arr.length-1] < key) return -1;

    int start = 0, end = arr.length-1;
    while(start <= end){
      int mid = start + (end-start)/2;
      if(arr[mid] == key) return mid;
      else if(arr[mid] < key){
        start = mid+1;
      }
      else { //arr[mid] > key
        end = mid-1;
      }
    }
    return start;
  }/*
  Time Complexity: O(logN)
  Space Complexity: O(1)
  */
}
