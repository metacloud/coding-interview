/*
Rearrange String K Distance Apart

Given a string and a number ‘K’, find if the string can be rearranged such that the same characters are at least ‘K’ distance apart from each other.
*/

class Solution {
    public class Pair {
        char ch;
        int cnt;
        Pair(char ch, int cnt){
            this.ch = ch;
            this.cnt = cnt;
        }
    }

    public String rearrangeString(String str, int k){
        if(k<=1 || str.length() < 2) return str;

        Map<Character, Integer> map = new HashMap<>();
        for(char ch : str.toCharArray()) map.put(ch, map.getOrDefault(ch,0)+1);

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair a, Pair b){
                return b.cnt-a.cnt != 0 ? b.cnt-a.cnt : a.ch-b.ch;
            }
        });

        for(char ch : map.keySet()) maxHeap.offer(new Pair(ch, map.get(ch)));

        StringBuilder sb = new StringBuilder();
        Queue<Pair> queue = new LinkedList<>();
        while(!maxHeap.isEmpty()){
            Pair temp = maxHeap.poll();
            sb.append(temp.ch);
            temp.cnt--;
            queue.offer(temp);

            if(queue.size()==k){
                Pair tmp = queue.poll();
                if(tmp.cnt > 0){
                    maxHeap.offer(tmp);
                }
            }
        }
        return sb.length()==str.length() ? sb.toString() : "";
    }
}/*
Time Complexity:
O(N*logN) where N is the number of characters in the input string
but input only contains at most 26 entries(lower case characters) => O(26log26) ~= O(N)

Space Complexity: O(N)
*/



/* Solution2

while(!maxHeap.isEmpty()){
    Queue<Pair> queue = new LinkedList<>();
    for(int i=0; i<k; i++){
        if(!maxHeap.isEmpty()){
            Pair temp = maxHeap.poll();
            sb.append(temp.ch);
            if(--temp.cnt>0) queue.offer(temp);
        } else {
            if(queue.size()==0) return sb.toString();
            return "";
        }
    }
    for(Pair n : queue){
        maxHeap.offer(n);
    }
}
return sb.toString();
*/
