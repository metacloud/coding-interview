/*
692. Top K Frequent Words
*/

class Solution {
    public class Word {
        String word;
        int freq;
        Word(String w, int f){
            word = w;
            freq = f;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        if(words==null || words.length==0) return new ArrayList<>();

        //HashMap to check frequency
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) +1);
        }

        //PriorityQueue for sorting
        PriorityQueue<Word> minHeap = new PriorityQueue<>(new Comparator<Word>(){
            @Override
            public int compare(Word a, Word b){
                return (a.freq-b.freq != 0 ? a.freq-b.freq : b.word.compareTo(a.word));
            }
        });

        //add all words to minHeap
        for(String word : map.keySet()){
            minHeap.offer(new Word(word, map.get(word)));
            if(minHeap.size()>k) minHeap.poll();
        }

        List<String> ret = new ArrayList<>();
        while(!minHeap.isEmpty()){
            ret.add(0, minHeap.poll().word);
        }
        return ret;
    }
}/*
Time Complexity: O(NlogK)
Space Complexity: O(N)
*/
