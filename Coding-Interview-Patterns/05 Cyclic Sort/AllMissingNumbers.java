
/*
Pattern: Cyclic Sort
03 Find all Missing Numbers (easy)

We are given an unsorted array containing numbers taken from the range 1 to ‘n’.
The array can have duplicates, which means some numbers will be missing.
Find all those missing numbers.

Input: [2, 3, 1, 8, 2, 3, 5, 1]
Output: 4, 6, 7
Explanation: The array should have all numbers from 1 to 8, due to duplicates 4, 6, and 7 are missing.
*/

import java.util.*;

class AllMissingNumbers {

  public static List<Integer> findNumbers(int[] nums){
    List<Integer> missingNumbers = new ArrayList<>();
    int i=0;
    while(i < nums.length){
      if(nums[i] != nums[nums[i]-1]){
        int correctIndex = nums[i]-1;
        int temp = nums[i];
        nums[i] = nums[correctIndex];
        nums[correctIndex] = temp;
      }
      else i++;
    }

    for(i=0; i<nums.length; i++){
      if(i != nums[i]-1){
        missingNumbers.add(i+1);
      }
    }
    return missingNumbers;
  }/*
  Time Complexity: O(N)
  Space Complexity: O(1)
  */

  public static void main(String[] args) {
    List<Integer> missing = AllMissingNumbers.findNumbers(new int[] { 2, 3, 1, 8, 2, 3, 5, 1 });
    System.out.println("Missing numbers: " + missing);

    missing = AllMissingNumbers.findNumbers(new int[] { 2, 4, 1, 2 });
    System.out.println("Missing numbers: " + missing);

    missing = AllMissingNumbers.findNumbers(new int[] { 2, 3, 2, 1 });
    System.out.println("Missing numbers: " + missing);
  }
}
