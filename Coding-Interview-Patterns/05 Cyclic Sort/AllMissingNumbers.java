/*
Pattern: Cyclic Sort
03 Find all Missing Numbers (easy)

We are given an unsorted array containing numbers taken from the range 1 to ‘n’.
The array can have duplicates, which means some numbers will be missing. Find all those missing numbers.

# LeetCode 448. Find All Numbers Disappeared in an Array [Easy]
[Result]
Runtime: 6 ms, faster than 80.27% of Java online submissions for Find All Numbers Disappeared in an Array.
Memory Usage: 47 MB, less than 97.83% of Java online submissions for Find All Numbers Disappeared in an Array.
*/

class AllMissingNumbers {
  public List<Integer> findNumbers(int[] nums){
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
}
