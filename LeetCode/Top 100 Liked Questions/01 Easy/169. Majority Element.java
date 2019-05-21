/*
169. Majority Element
*/


//HashMap
class Solution {
    public int majorityElement(int[] nums){
      HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
      if(nums.length <= 1){
        return nums[0];
      }
      for(int i : nums){
        if(hashmap.get(i) == null){
          hashmap.put(i,1);
        }
        else{
          hashmap.put(i, hashmap.get(i)+1);
          if(hashmap.get(i) > nums.length/2){
            return i;
          }
        }
      }
    return -1;
  }
}


//Sorting
class Solution {
    public int majorityElement(int[] nums){
      Arrays.sort(nums);
      return nums[nums.length/2];
  }
}
