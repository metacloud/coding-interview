
/*
Pattern: Cyclic Sort
06 Find all Duplicate Numbers (easy)

We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’.
The array originally contained all the numbers from 1 to ‘n’, but due to a data error,
one of the numbers got duplicated which also resulted in one number going missing.
Find both these numbers.

[Example]
Input: [3, 1, 2, 5, 2]
Output: [2, 4]
Explanation: '2' is duplicated and '4' is missing.

*/

class FindCorruptNums {
  public static int[] findNumbers(int[] nums) {

    int i=0;
    while(i < nums.length){
      if(i != nums[i]-1 && nums[i] != nums[nums[i]-1]){
        int correctIndex = nums[i]-1;
        int temp = nums[i];
        nums[i] = nums[correctIndex];
        nums[correctIndex] = temp;
      }
      else {
        i++;
      }
    }

    for(i=0; i<nums.length; i++){
      if(i != nums[i]-1){
        return new int[] { nums[i], i+1 };
      }
    }

    return new int[] {-1,-1};
  }

  public static void main(String[] args) {
    int[] nums = FindCorruptNums.findNumbers(new int[] { 3, 1, 2, 5, 2 });
    System.out.println(nums[0] + ", " + nums[1]);
    nums = FindCorruptNums.findNumbers(new int[] { 3, 1, 2, 3, 6, 4 });
    System.out.println(nums[0] + ", " + nums[1]);
  }
}
