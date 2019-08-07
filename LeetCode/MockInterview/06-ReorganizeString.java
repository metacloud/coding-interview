/*
767. Reorganize String
*/

class Solution {
    public class charCnt {
        char ch;
        int cnt;
        charCnt(char ch, int cnt){
            this.ch = ch;
            this.cnt = cnt;
        }
    }
              
    public String reorganizeString(String str) {
        if(str.length()==0 || str==null) return "";

        //all characters -> hashmap <character, frequency>
        Map<Character, Integer> map = new HashMap<>();
        for (char chr : str.toCharArray()) map.put(chr, map.getOrDefault(chr, 0) + 1);

        //maxHeap to sort by frequency
        PriorityQueue<charCnt> maxHeap = new PriorityQueue<charCnt>((a, b) -> b.cnt - a.cnt);

        // add all characters to the maxHeap
        for(char ch : map.keySet()) maxHeap.offer(new charCnt(ch, map.get(ch)));

        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
          charCnt curr = maxHeap.poll();
          if(sb.length() ==0 || sb.charAt(sb.length()-1) != curr.ch){ // we can add
              sb.append(curr.ch);
              if(--curr.cnt > 0) maxHeap.offer(curr); //--curr.cnt : 반영됨?
          } 
          else { //we need to get another char to prevent consecutive sequence, a a(curr) b(next)
              if(maxHeap.isEmpty()) return "";
                  
              charCnt next = maxHeap.poll();
              sb.append(next.ch);
              if(--next.cnt > 0) maxHeap.offer(next);
              sb.append(curr.ch);
              if(--curr.cnt > 0) maxHeap.offer(curr);
          }  
        }  
        return sb.toString();
  }    

}