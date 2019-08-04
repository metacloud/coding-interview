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
}