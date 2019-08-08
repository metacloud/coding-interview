/*
819. Most Common Word
*/

class Solution {

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        for(String word : banned) set.add(word);

        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        paragraph += ".";
        int max = 0; String ret="";
        for(int i=0; i<paragraph.length(); i++){
            char curr = paragraph.charAt(i);
            if(curr >= 'a' && curr <='z' || curr >= 'A' && curr <='Z'){
                sb.append(curr);
            }
            else if (sb.length()>0)
            {
                String str = sb.toString().toLowerCase();
                if(!set.contains(str)){
                    map.put(str, map.getOrDefault(str,0)+1);
                    if(map.get(str) > max){
                        max = map.get(str);
                        ret = str;
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



class Solution { //regular expression

    public String mostCommonWord(String paragraph, String[] banned){
        String[] words = paragraph.toLowerCase().split("\\W+");

        HashMap<String, Integer> hashmap = new HashMap<>();
        for(String word : words){ //Add all words to hashmap
            hashmap.put(word, hashmap.getOrDefault(word,0)+1);
        }

        for(String bannedWord : banned) { // Remove all banned words from hashmap
            if(hashmap.containsKey(bannedWord)) hashmap.remove(bannedWord);
        }

        String frequentWord = null;
        for(String word : hashmap.keySet()){ // find the most frequent word
            if(frequentWord == null || hashmap.get(frequentWord) < hashmap.get(word)){
                frequentWord = word;
            }
        }
        return frequentWord;
    }
}
