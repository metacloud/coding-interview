/*
763. Partition Labels
*/

class Solution {
    public List<Integer> partitionLabels(String S) {

        // total alphabet : 26
        int[] lastIndex = new int[26];

        // each Index: alphabet-'a' will have their alphabet's last index position
        for(int i=0; i<S.length(); i++){
            lastIndex[S.charAt(i)-'a'] = i;
        }

        List<Integer> ret = new ArrayList<Integer>();

        int currLast=0, start=0;
        for(int i=0; i<S.length(); i++){
            currLast = Math.max(currLast, lastIndex[S.charAt(i)-'a']);

            if(i==currLast){ //find one complete part
                ret.add(currLast-start+1);
                start=currLast+1;
            }
        }
        return ret;
    }
}/*
Time Complexity: O(N)
Space Complexity: O(1)
=> alphabet:26 ; O(26)~= O(1) 
If the size(space) does not increase in size with the respect to input N, then it is constant space, O(1)
*/
