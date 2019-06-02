/*
Pattern: Two Pointers
03 Squaring a Sorted Array (easy)

Given a sorted array,
create a new array containing squares of all the number of the input array
in the sorted order.

# LeetCode 977. Squares of a Sorted Array
[Result]
Runtime: 2 ms, faster than 84.21% of Java online submissions for Squares of a Sorted Array.
Memory Usage: 41 MB, less than 96.70% of Java online submissions for Squares of a Sorted Array.
*/

import java.util.Arrays;

class SortedArraySquares {

  //Intuition
  public static int[] sortedSquares(int[] arr){
    int[] squares = new int[arr.length];
    for(int i=0; i<arr.length; i++){
      squares[i] = arr[i]*arr[i];
    }
    Arrays.sort(squares);
    return squares;
  }/*
  Time Complexity: O(NlogN)
  Space Complexity: O(N)
  */


  public static int[] makeSquares(int[] arr) {
    int[] squares = new int[arr.length];
    int negDir = 0, posDir = 0;
    for(int i=0; i<arr.length; i++){
      if(arr[i] >= 0){
        posDir = i;
        negDir = i-1;
        break;
      }
    }

    for(int i=0; i < arr.length; i++){
        if(negDir >=0 && posDir < arr.length){
            if(Math.abs(arr[negDir]) < Math.abs(arr[posDir])){
              squares[i] = arr[negDir]*arr[negDir];
              negDir--;
            } else{
              squares[i] = arr[posDir]*arr[posDir];
              posDir++;
            }
        }
        else if(negDir >=0){//only negative elements are left
          squares[i] = arr[negDir]*arr[negDir];
          negDir--;
        }
        else {//only positive elements are left
          squares[i] = arr[posDir]*arr[posDir];
          posDir++;
        }
    }
    return squares;
  }/*
  Time Complexity: O(N)
  Space Complexity: O(N)
  */

  public static void main(String[] args) {

    int[] result = SortedArraySquares.sortedSquares(new int[] { -2, -1, 0, 2, 3 });
    for (int num : result)
      System.out.print(num + " ");
    System.out.println();

    result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
    for (int num : result)
      System.out.print(num + " ");
    System.out.println();


    result = SortedArraySquares.sortedSquares(new int[] { -3, -1, 0, 1, 2 });
    for (int num : result)
      System.out.print(num + " ");
    System.out.println();

    result = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2 });
    for (int num : result)
      System.out.print(num + " ");
    System.out.println();
  }
}
