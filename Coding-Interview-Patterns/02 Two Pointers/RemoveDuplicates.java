/*
Pattern: Two Pointers
02 Remove Duplicates (easy)

Given an array of sorted numbers, remove all duplicates from it.
You should not use any extra space; after removing the duplicates in-place
return the new length of the array.

# LeetCode 26. Remove Duplicates from Sorted Array [Easy]
[Result]
Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted Array.
Memory Usage: 38.6 MB, less than 99.98% of Java online submissions for Remove Duplicates from Sorted Array.
*/

class RemoveDuplicates {
  public static int remove(int[] arr){
    if(arr.length==0) return 0;
    int current = 0; // length of nonDuplicate array.
    for(int i=1; i<arr.length; i++){
      if(arr[current] != arr[i]){
        current++;
        arr[current] = arr[i];
      }
    }
    return current+1;
  }/*
  Time Complexity: O(N)
  Space Complexity: O(1)
  */
}
