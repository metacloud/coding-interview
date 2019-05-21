/*
136. Single Number
*/


//HashSet
class Solution {
    public int singleNumber(int[] nums){
        HashSet<Integer> hashset = new HashSet<Integer>();

        for(int n : nums) {
            if(hashset.contains(n)){
                hashset.remove(n);
            } else {
                hashset.add(n);
            }
        }
        for(int i : hashset) {
          return i;
        }
        return -1;

    }
}


//Bit Manipulation
/*
0010 2
XOR 1010 8 + 2
----
1    xor(0, 1)
 0   xor(0, 0)
  0  xor(1, 1)
   0 xor(0, 0)
----
=  1000 8
*/
class Solution {
    public int singleNumber(int[] nums) {

        int result = nums[0];
        for(int i=1 ; i< nums.length; i++){
            result = result ^ nums[i];
        }
        return result;
    }
}
