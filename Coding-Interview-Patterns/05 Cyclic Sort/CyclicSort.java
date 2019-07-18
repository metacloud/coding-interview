/*
Pattern: Cyclic Sort
01 Cyclic Sort (easy)

We are given an array containing ‘n’ objects.
Each object, when created, was assigned a unique number from 1 to ‘n’ based on their creation sequence.
This means that the object with sequence number ‘3’ was created just before the object with sequence number ‘4’.

Write a function to sort the objects in-place on their creation sequence number in O(n)O(n) and without any extra space.
For simplicity, let’s assume we are passed an integer array containing only the sequence numbers,
though each number is actually an object.
*/

class CyclicSort {
  public void sort(int[] nums){
      int i=0;
      while(i<nums.length){
        if(nums[i] == i+1){
          i++;
        } else {
          int correctIndex = nums[i]-1;
          int temp = nums[i];
          nums[i] = nums[correctIndex];
          nums[correctIndex] = temp;
        }
      }
  }/*
  Time Complexity: O(N)
  Space Complexity: O(1)
  */
}
