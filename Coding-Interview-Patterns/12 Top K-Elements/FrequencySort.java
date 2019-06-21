/*
Pattern: Top 'K' Elements
06 Frequency Sort (medium)

Given a string, sort it based on the decreasing frequency of its characters.

[Example]
Input: "abcbab"
Output: "bbbaac"
Explanation: 'b' appeared three times, 'a' appeared twice, and 'c' appeared only once.

# LeetCode 451. Sort Characters By Frequency [Medium]
[Result]
Runtime: 46 ms, faster than 38.96% of Java online submissions for Sort Characters By Frequency.
Memory Usage: 39.1 MB, less than 74.56% of Java online submissions for Sort Characters By Frequency.
*/

import java.util.*;

class FrequencySort {
  public static String sortCharacterByFrequency(String str) {

    HashMap<Character, Integer> hashmap = new HashMap<>();
    for(char ch : str.toCharArray()){
      hashmap.put( ch, hashmap.getOrDefault(ch, 0) + 1 );
    }

    PriorityQueue<Character> maxHeap = new PriorityQueue<>(
      (a,b) -> ( hashmap.get(b) - hashmap.get(a))
    );

    for(char ch : hashmap.keySet()){
      maxHeap.add(ch);
    }

    StringBuilder sortedStr = new StringBuilder(str.length());
    while(!maxHeap.isEmpty()){
      int repeated = hashmap.get(maxHeap.peek());
      char repeatChar = maxHeap.poll();

      for(int i=0; i < repeated; i++){
        sortedStr.append(repeatChar);
      }
    }

    return sortedStr.toString();
  }/*
  Time Complexity: O(K*logK) where K is the number of distinct characters in the input string.
  In the worst case, when all characters are unique the time Complexity of the algorithm will be
  O(N*logN) where N is the total number of characters in the string.

  Space Complexity: O(N)
  */

  public static void main(String[] args) {
    String result = FrequencySort.sortCharacterByFrequency("Programming");
    System.out.println("Here is the given string after sorting characters by frequency: " + result);

    result = FrequencySort.sortCharacterByFrequency("abcbab");
    System.out.println("Here is the given string after sorting characters by frequency: " + result);
  }
}
