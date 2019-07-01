/*
Pattern: Modified Binary Search
08 Search Bitonic Array (medium)

Given a Bitonic array, find if a given ‘key’ is present in it.
An array is considered bitonic if it is monotonically increasing and then monotonically decreasing.
Monotonically increasing or decreasing means that for any index i in the array arr[i] != arr[i+1].

Write a function to return the index of the ‘key’. If the ‘key’ is not present, return -1.

[Example]
Input: [1, 3, 8, 4, 3], key = 4
Output: 3
*/

class SearchBitonicArray { // 10 9 8   start = 0, end = 0 , mid = 1

  public static int search(int[] arr, int key) {

    int start = 0, end = arr.length-1;
    while(start < end){
        int mid = start + (end-start)/2;

        if(arr[mid] > arr[mid+1]){ // we are in descending part
          if(arr[mid] == key) return mid;
          else if(arr[mid] > key){
            start = mid+1;
          }
          else { //arr[mid] < key
            end = mid-1;
          }
        }

        else { // arr[mid] <= arr[mid+1] // we are in ascending part
          if(arr[mid] == key) return mid;
          else if(arr[mid] > key){
            end = mid - 1;
          }
          else { //arr[mid] < key
            start = mid+1;
          }
        }
    }

    if(arr[start] == key){
      return start;
    }

    return -1;
  }

  public static void main(String[] args) {
    System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 4, 3 }, 4));
    System.out.println(SearchBitonicArray.search(new int[] { 3, 8, 3, 1 }, 8));
    System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 12 }, 12));
    System.out.println(SearchBitonicArray.search(new int[] { 10, 9, 8 }, 10));
  }
}
