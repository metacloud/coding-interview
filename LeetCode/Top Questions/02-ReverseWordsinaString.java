/*
151. Reverse Words in a String
*/

class Solution {
    public String reverseWords(String s) {
        if(s==null || s.length()==0) return "";

        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i)==' ') continue;
            int end = i;
            while(i>=0 && s.charAt(i)!=' ') i--;
            String wd = s.substring(i+1, end+1);
            sb.append(wd+" ");
        }
        return sb.toString().trim();
    }
}/*
Time Complexity: O(N)
Space Complexity: O(N) for StringBuilder
*/


// If you want to know how to use trim & split
class Solution {
    public String reverseWords(String s) {
        if(s==null || s.length()==0) return "";

        String[] words = s.split(" +");
        StringBuilder sb = new StringBuilder();
        for(int i=words.length-1; i>=0; i--){
            if(sb.length()>0) sb.append(" ");
            sb.append(words[i]);
        }
        return sb.toString();
    }
}
