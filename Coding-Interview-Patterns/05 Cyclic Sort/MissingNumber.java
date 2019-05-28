
/*
Pattern: Cyclic Sort
02 Find the Missing Number (easy)

We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’.
Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.
*/


class MissingNumber {


  public static int findMissingNumber(int[] nums) {
      int i=0;
      while(i < nums.length){
        if(nums[i] < nums.length && nums[i] != nums[nums[i]]){
          swap(nums, i, nums[i]);
        } else {
          i++;
        }
      } //Sorting

      for(i=0; i<nums.length; i++){
        if(nums[i] != i)
          return i;
      }
      return nums.length;
  }

  //swap function
  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static int findMissingNumber_SUM(int[] nums){
    int n = nums.length;
    int total = (n)*(n+1)/2;
    for(int i=0; i<nums.length; i++){
      total = total - nums[i];
    }
    return total;
  }

  public static int findMissingNumber_XOR(int[] nums){
    int ret = 0;
    for(int i=1; i<=nums.length; i++){
      ret = ret^i;
    }

    for(int i=0; i<nums.length; i++){
      ret = ret^nums[i];
    }
    return ret;
  }

  public static void main(String[] args) {
    System.out.println(MissingNumber.findMissingNumber(new int[] { 4, 0, 3, 1 }));
    System.out.println(MissingNumber.findMissingNumber_SUM(new int[] { 4, 0, 3, 1 }));
    System.out.println(MissingNumber.findMissingNumber_XOR(new int[] { 4, 0, 3, 1 }));
    System.out.println(MissingNumber.findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
    System.out.println(MissingNumber.findMissingNumber_SUM(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
    System.out.println(MissingNumber.findMissingNumber_XOR(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
  }
}
