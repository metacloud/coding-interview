/*
Pattern: Two Pointers
02.5 Remove Element (easy)

Given an unsorted array of numbers and a target ‘key’,
remove all instances of ‘key’ in-place and return the new length of the array.
*/

class RemoveElement {
  public static int remove(int[] arr, int key){

    int rmKeyArray = 0;
    for(int i=0; i < arr.length; i++){
      if(arr[i] != key){
        //arr[rmKeyArray] = arr[i];
        rmKeyArray++;
      }
    }
    return rmKeyArray;
  } /*
  Time Complexity: O(N)
  Space Complexity: O(1)
  */

  public static void main(String[] args){
    int[] arr = new int[] {3, 2, 3, 6, 3, 10, 9, 3};
    System.out.println(RemoveElement.remove(arr, 3));

    arr = new int[] {2, 11, 2, 2, 1};
    System.out.println(RemoveElement.remove(arr,2));
  }
}
