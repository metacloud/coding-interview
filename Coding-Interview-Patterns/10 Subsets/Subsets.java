/*
Pattern: Subsets
01 Subsets (easy)

Given a set with distinct elements, find all of its distinct subsets.
*/


import java.util.*;

class Subsets {
  public static List<List<Integer>> findSubsets(int[] nums) {
    List<List<Integer>> subsets= new ArrayList<>();

    return subsets;
  }

  public static void main(String[] args){
    List<List<Integer>> result = Subsets.findSubsets(new int[] {1,3});
    System.out.println("Here is the list of subsets: " + result);

    result = Subsets.findSubsets(new int[] {1,5,3});
    System.out.println("Here is the list of subsets: " + result);
  }
}
