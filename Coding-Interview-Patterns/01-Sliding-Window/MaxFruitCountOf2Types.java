/*
Pattern: Sliding Window
04 Fruits into Baskets (medium)

Given an array of characters where each character represents a fruit tree,
you are given two baskets and your goal is to put maximum number of fruits in each basket.
The only restriction is that each basket can have only one type of fruit.

You can start with any tree, but once you have started you can’t skip a tree.
You will pick one fruit from each tree until you cannot, i.e.,
you will stop when you have to pick from a third fruit type.

Write a function to return the maximum number of fruits in both the baskets.

[Example]
Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
Output: 5
Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']

*/

import java.util.*;

class MaxFruitCountOf2Types {

  public static int findLength(char[] arr) {
    HashMap<Character, Integer> basket = new HashMap<>();

    int start = 0, end = 0, maxFruit = 0;
    for(end = 0; end < arr.length; end++){
      char addFruit = arr[end];
      basket.put(addFruit, basket.getOrDefault(addFruit, 0)+1);

      while(basket.size() > 2){
        char removeFruit = arr[start];
        basket.put(removeFruit, basket.get(removeFruit)-1);
        if(basket.get(removeFruit) == 0){
          basket.remove(removeFruit);
        }
        start++;
      }
      int currFruit = end - start + 1;
      maxFruit = Math.max(maxFruit, currFruit);
    }
    return maxFruit;
  }

  public static void main(String[] args) {
    System.out.println("Maximum number of fruits: " +
                          MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
    System.out.println("Maximum number of fruits: " +
                          MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
  }
}
