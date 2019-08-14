/*
Roll Dice
*/

/*
Input: A = [1, 2, 3]
Output: 2
Explanation: You can pick the first two dice and rotate each of them in one move so that they all show three pips on the top face. Notice that you can also pick any other pair of dice in this case.
*/

class Solution {
    public int RollDice(int[] arr) {
        if(arr.length==0) return 0;

        int min = Integer.MAX_VALUE;
        for(int pip=1; pip<7; pip++){ //dice face 1-6 available
            int move = 0;
            for(int num : arr){
                if(num == pip) continue;
                else if(num + pip==7) move+=2;
                else move+=1;
            }
            min = Math.min(min, move);
        }
        return min;
    }
}/*
Time Complexity: O(N)
Space Complexity: O(1)
*/
