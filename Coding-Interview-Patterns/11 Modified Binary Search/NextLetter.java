/*
Pattern: Modified Binary Search
03 Next Letter (medium)

Given an array of lowercase letters sorted in ascending order,
find the smallest letter in the given array greater than a given ‘key’.

Assume the given array is a circular list,
which means that the last letter is assumed to be connected with the first letter.
This also means that the smallest letter in the given array is greater than the last letter of the array
and is also the first letter of the array.

Write a function to return the next letter of the given ‘key’.

Input: ['a', 'c', 'f', 'h'], key = 'f'
Output: 'h'
Explanation: The smallest letter greater than 'f' is 'h' in the given array.

Input: ['a', 'c', 'f', 'h'], key = 'h'
Output: 'a'
Explanation: As the array is assumed to be circular, the smallest letter greater than 'h' is 'a'.
*/


class NextLetter {

  public static char searchNextLetter(char[] letters, char key){
     int len = letters.length;
     if(key < letters[0] || key > letters[len-1]) return letters[0];

     int start = 0, end = len-1;
     while(start <= end){
       int mid = start + (end-start)/2;
       if(key < letters[mid]){
         end = mid-1;
       } else { // key >= letters[mid]
         start = mid+1;
       }
     }
      return letters[start % len];
  }

  public static void main(String[] args){
    System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
    System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
    System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
    System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
  }
}
