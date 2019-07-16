/*
Pattern: Two Pointers
02.5 Remove Element (easy)

Given an unsorted array of numbers and a target ‘key’, 
remove all instances of ‘key’ in-place and return the new length of the array.

# LeetCode 27. Remove Element [Easy]
[Result]
Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.
Memory Usage: 34.6 MB, less than 100.00% of Java online submissions for Remove Element.
*/

class RemoveElement {
  public static int remove(int[] arr, int key){
    int removedKey = 0;
    for(int i=0; i < arr.length; i++){
      if(arr[i] != key){
        arr[removedKey] = arr[i];
        removedKey++;
      }
    }
    return removedKey;
  } /*
  Time Complexity: O(N)
  Space Complexity: O(1)
  */
}
