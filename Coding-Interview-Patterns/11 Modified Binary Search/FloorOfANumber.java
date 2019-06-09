/*
Pattern: Modified Binary Search
02.5 Floor of a Number (medium)

Given an array of numbers sorted in ascending order,
find the floor of a given number ‘key’.
The floor of the ‘key’ will be the biggest element in the given array smaller than or equal to the ‘key’
Write a function to return the index of the floor of the ‘key’. If there isn’t a floor, return -1.

Input: [4, 6, 10], key = 17
Output: 2
Explanation: The biggest number smaller than or equal to '17' is '10' having index '2'.
*/

class FloorOfANumber {
  public static int searchFloorOfANumber(int[] arr, int key) {
    int start = 0, end = arr.length-1;
    int floorVal = -1;

    while(start<=end){
      int mid = start + (end-start)/2;
      if(arr[mid]==key) return mid;
      else if(arr[mid]<key){
        floorVal = mid;
        start = mid+1;
      }
      else{//arr[mid]>key
        end = mid-1;
      }
    }
    return floorVal;
  }

  public static void main(String[] args) {
    System.out.println(FloorOfANumber.searchFloorOfANumber(new int[] { 4, 6, 10 }, 6));
    System.out.println(FloorOfANumber.searchFloorOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
    System.out.println(FloorOfANumber.searchFloorOfANumber(new int[] { 4, 6, 10 }, 17));
    System.out.println(FloorOfANumber.searchFloorOfANumber(new int[] { 4, 6, 10 }, -1));
  }

}
