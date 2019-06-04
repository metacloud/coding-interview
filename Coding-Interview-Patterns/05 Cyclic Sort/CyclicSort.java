
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

  public static void sort(int[] nums) {
    for(int i = 0; i < nums.length; i++){
      if(i != nums[i]-1){ //3 2 1
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

  public static void sort2(int[] nums){
      int i=0;
      while(i<nums.length){
        int correctIndex = nums[i]-1;
        if(i==correctIndex){
          i++;
        } else {
          int temp = nums[i];
          nums[i] = nums[correctIndex];
          nums[correctIndex] = temp;
        }
      }
  }

  public static void main(String[] args) {
    int[] arr = new int[] { 3, 1, 5, 4, 2 };
    CyclicSort.sort(arr);
    for (int num : arr)
      System.out.print(num + " ");
    System.out.println();

    arr = new int[] { 2, 6, 4, 3, 1, 5 };
    CyclicSort.sort(arr);
    for (int num : arr)
      System.out.print(num + " ");
    System.out.println();
  }
}
