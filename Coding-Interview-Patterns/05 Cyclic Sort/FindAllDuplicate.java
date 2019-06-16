
/*
Pattern: Cyclic Sort
05 Find all Duplicate Numbers (easy)

We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’.
The array has some duplicates, find all the duplicate numbers without using any extra space.

Input: [3, 4, 4, 5, 5]
Output: [4, 5]

*/


import java.util.*;

class FindAllDuplicate {

  public static List<Integer> findNumbers(int[] nums) {

    int index=0;
    while(index<nums.length){
      if(nums[index] != index+1 ){
        if(nums[index] == nums[nums[index]-1]) {
          if(!duplicateNumbers.contains(nums[index])){
            duplicateNumbers.add(nums[index]);
          }
          index++;
        }
        else{
          int correctIndex = nums[index]-1;
          int temp = nums[index];
          nums[index] = nums[correctIndex];
          nums[correctIndex] = temp;
        }
      }
      else {
        index++;
      }
    }
    return duplicateNumbers;
  }

  public static void main(String[] args) {
    List<Integer> duplicates = FindAllDuplicate.findNumbers(new int[] { 4, 4, 4, 5, 5 });
    System.out.println("Duplicates are: " + duplicates);

    duplicates = FindAllDuplicate.findNumbers(new int[] { 5, 4, 7, 2, 3, 5, 3 });
    System.out.println("Duplicates are: " + duplicates);
  }
}
