/*
Longest string without 3 consecutive characters
*/

/*
Given A, B, C, find any string of maximum length that can be created such that no 3 consecutive characters are same. There can be at max A 'a', B 'b' and C 'c'.

Input: A = 1, B = 1, C = 6
Output: "ccbccacc"
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

    public String longestString(int A, int B, int C){

        Pair a = new Pair('a', A);
        Pair b = new Pair('b', B);
        Pair c = new Pair('c', C);

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair a, Pair b){
                return b.cnt-a.cnt !=0 ? b.cnt-a.cnt : a.ch-b.ch;
            }
        });

        maxHeap.offer(a);
        maxHeap.offer(b);
        maxHeap.offer(c);

        StringBuilder sb = new StringBuilder();
        Queue<Pair> queue = new LinkedList<>();
        while(!maxHeap.isEmpty()){
            int count=0;
            while(count<3 && !maxHeap.isEmpty()){
                Pair temp = maxHeap.poll();
                if(temp.cnt >= 2){
                    sb.append(temp.ch);
                    sb.append(temp.ch);
                    temp.cnt--;
                    temp.cnt--;
                    count++;
                    count++;
                    if(temp.cnt>0) queue.offer(temp);
                } else { //cnt==1
                    sb.append(temp.ch);
                    temp.cnt--;
                    count++;
                }
            }

            //it means we just added same char twice, and the char in the queue is the same one we just added.
            if(count<3 && queue.size()>0) return "";
            while(!queue.isEmpty()){
                maxHeap.offer(queue.poll());
            }
        }

        return sb.toString();
    }
}
