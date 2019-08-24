/*
127. Word Ladder
*/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;

        //need to look up elements in O(1)
        Set<String> wordSet = new HashSet<>();
        for(String word : wordList) wordSet.add(word);

        //BFS approach for Shortest Transformation => queue
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int len = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                String curr = queue.poll();
                if(curr.equals(endWord)) return len+1;
                for(int j=0; j<curr.length(); j++){
                    char[] word = curr.toCharArray();
                    for(char k='a'; k<='z'; k++){
                        word[j] = k;
                        String wd = new String(word);
                        if(!wd.equals(curr) && wordSet.contains(wd)){
                            queue.offer(wd);
                            wordSet.remove(wd);
                        }
                    }
                }
            }
            len++;
        }
        return 0;
    }
}
/*
Time Complexity: O(L*N) where L is the length of the word, N is the number of words.
Space Complexity: O(N)
*/
