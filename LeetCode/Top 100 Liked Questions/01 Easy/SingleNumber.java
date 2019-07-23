/*
LeetCode 136. Single Number

[Result] Bit Manipulation
Runtime: 0 ms, faster than 100.00% of Java online submissions for Single Number.
Memory Usage: 38.3 MB, less than 99.62% of Java online submissions for Single Number.
*/

//Bit Manipulation
/*
If we take XOR of zero and some bit, it will return that bit
a XOR 0 = a
If we take XOR of two same bits, it will return 0
a XOR a = 0
=> We can XOR all bits together to find the unique number.
   a XOR b XOR a = (a XOR a) XOR b = 0 XOR b = b
*/
class Solution {
    public int singleNumber(int[] nums) {

        int uniqueNum = 0;
        for(int i=0 ; i< nums.length; i++){
            uniqueNum = uniqueNum ^ nums[i];
        }
        return uniqueNum;
    }
}/*
Time Complexity: O(N)
Space Complexity: O(1)
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
}/*
Time Complexity: O(N)
Space Complexity: O(N)
*/

//HashTable
class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            hashmap.put(nums[i], hashmap.getOrDefault(nums[i],0)+1);
            /*
            if(hashmap.containsKey(nums[i])){
                hashmap.put(nums[i], hashmap.get(nums[i])+1);
            } else {
              hashmap.put(nums[i], 1);  
            }*/
        }
        for(int key : hashmap.keySet()){
            if(hashmap.get(key).equals(1)){
                return key;
            }
        }
        return -1;
    }
}/*
Time Complexity: O(N)
Space Complexity: O(N)
*/
/*
map.put(key, map.getOrDefault(key,0) + 1);
This uses the method of HashMap that retrieves the value for a key, 
but if the key can't be retrieved it returns the specified default value (in this case a '0').
*/


