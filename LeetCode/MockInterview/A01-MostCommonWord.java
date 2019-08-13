/*
819. Most Common Word
*/

/*
Input:
literatureText = “Jack and Jill went to the market to buy bread and cheese. Cheese is Jack's and Jill’s favorite food.”
wordsToExclude = ["and", "he", "the", "to", "is", "Jack", "Jill"]

Output:
["cheese", “s”]

Explanation:
The word “and” has a maximum of three frequency but this word should be excluded while analyzing the word frequency.
The words “Jack”, “Jill”, “s”, "to" and "cheese” have the next maximum frequency(two) in the given text but the words “Jack”, "to" and “Jill” should be excluded as these are commonly used words which you are not interested to include.
So the output is ["cheese", “s”] or [“s”, "cheese"] as the order of words does not matter.*/

https://leetcode.com/discuss/interview-question/330023/Amazon-or-OA-or-Most-common-word-and-Substring-with-K-distinct-characters
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
