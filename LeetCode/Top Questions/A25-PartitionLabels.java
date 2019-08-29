/*
763. Partition Labels
*/

class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ret = new ArrayList<Integer>();
        if(S==null || S.length()==0) return ret;

        int[] lastIndex = new int[26];
        for(int i=0; i<S.length(); i++){ // last index position
            lastIndex[S.charAt(i)-'a'] = i;
        }

        int start=0, end = 0;
        for(int i=0; i<S.length(); i++){
            char curr = S.charAt(i);
            end = Math.max(end, lastIndex[curr-'a']);
            if(end == i){
                int len = end-start+1;
                ret.add(len);
                start = i+1;
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
