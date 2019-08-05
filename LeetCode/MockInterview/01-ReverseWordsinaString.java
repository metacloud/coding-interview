/*
151. Reverse Words in a String
*/

class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i) == ' ') continue;
            int j = i;
            while(i>=0 && s.charAt(i)!=' ') i--;
            sb.append(s.substring(i+1, j+1)).append(" ");
        }
        return sb.toString().trim();
    }
}/*
Time Complexity: O(N)
Space Complexity: O(N)
*/

// If you want to know how to use trim & split
class Solution {
    public String reverseWords(String s) {      
        s = s.trim().replaceAll(" +", " ");        
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=words.length-1; i>=0; i--){
            sb.append(words[i]);
            if(i>0) sb.append(" ");
        }
        return sb.toString();
    }
}
