/*
819. Most Common Word
*/

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        Set<String> bannedWord = new HashSet<>();
        for(String i : banned) bannedWord.add(i);

        Map<String, Integer> wordCnt = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        paragraph += ".";
        int maxCnt= 0; String ret= "";
        for(int i=0; i<paragraph.length(); i++){
            char curr = paragraph.charAt(i);
            if(curr>='a' && curr<='z' || curr>='A' && curr<='Z'){
                sb.append(curr);
            }
            else if(sb.length()>0){
                String word = sb.toString().toLowerCase();
                if(!bannedWord.contains(word)){
                    wordCnt.put(word, wordCnt.getOrDefault(word,0)+1);
                    if(wordCnt.get(word) > maxCnt) {
                        ret = word;
                        maxCnt = wordCnt.get(word);
                    }
                }
                sb = new StringBuilder();
            }
        }
        return ret;
    }
}/*
Time Complexity: O(P+B) where P is the size of paragraph, B is the size of banned
Space Complexity: O(P+B)
*/
