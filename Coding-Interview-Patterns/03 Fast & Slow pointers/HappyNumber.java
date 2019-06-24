
/*
Pattern: Fast & Slow pointers
03 Happy Number (medium)

Any number will be called a happy number if,
after repeatedly replacing it with a number equal to the sum of the square of all of its digits, leads us to number ‘1’.
All other (not-happy) numbers will never reach ‘1’.
Instead, they will be stuck in a cycle of numbers which does not include ‘1’.

# LeetCode 202. Happy Number [Easy]
[Result]
Runtime: 1 ms, faster than 93.56% of Java online submissions for Happy Number.
Memory Usage: 33.2 MB, less than 6.34% of Java online submissions for Happy Number.
*/

class HappyNumber {
  /*
  Time Complexity:
  Space Complexity: O(1)
  */

  public static boolean find(int num) {

    int slow = num, fast = num;
    do {
      slow = getSum(slow);
      fast = getSum(getSum(fast));
    } while(slow != fast);
    //1. has a cycle => 'slow == fast' in the end
    //2. happy number ? =>  reach to 1 => 'slow==fast' in the end

    if(fast==1) return true;

    return false;
  }

  private static int getSum (int num){

    int sum = 0, digit = 0;
    while(num > 0){
      digit = num % 10;
      sum += digit * digit;
      num = num / 10;
    }
    return sum;
  }

  public static void main(String[] args) {
    System.out.println(HappyNumber.find(23));
    System.out.println(HappyNumber.find(12));
  }
}
