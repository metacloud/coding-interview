/*
819. Most Common Word
*/

class Solution {
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

