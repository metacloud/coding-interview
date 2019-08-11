/*
1100. Find K-Length Substrings With No Repeated Characters
*/

class Solution {
    public int numKLenSubstrNoRepeats(String S, int K) {
        if(S==null || S.length()==0) return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int num=0, start=0;
        for(int i=0; i<S.length(); i++){
            char curr = S.charAt(i);
            if(map.containsKey(curr)){
                start= Math.max(start, map.get(curr)+1);
            }
            map.put(curr, i);
            if(i-start+1 == K){
                num++;
                start++;
            }
        }
        return num;
    }
}
