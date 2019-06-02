/*
Pattern: Two Pointers
02 Remove Duplicates (easy)

Given an array of sorted numbers, remove all duplicates from it.
You should not use any extra space; after removing the duplicates in-place
return the new length of the array.

# LeetCode 26. Remove Duplicates from Sorted Array [Easy]
[Result]
Runtime: 1 ms, faster than 99.75% of Java online submissions for Remove Duplicates from Sorted Array.
Memory Usage: 38.8 MB, less than 99.87% of Java online submissions for Remove Duplicates from Sorted Array.
*/


class RemoveDuplicates {
  public static int remove(int[] arr){
    if(arr.length==0) return 0;

    int current = 0; // length of nonDuplicate array.
    for(int check=1; check < arr.length; check++){
      if(arr[current] != arr[check]){
        current++;
        arr[current] = arr[check];
      }
    }
    return current+1;
  } /*
  Time Complexity: O(N)
  Space Complexity: O(1)
  */

  public static void main(String[] args){
    int[] arr = new int[] {2, 3, 3, 3, 6, 9, 9};
    System.out.println(RemoveDuplicates.remove(arr));

    arr = new int[] {2, 2, 2, 11};
    System.out.println(RemoveDuplicates.remove(arr));
  }
}
