/*
20. Valid Parentheses
*/

class Solution {
    public boolean isValid(String s){
        if(s.length() %2 !=0) return false;

        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '('){
                stack.push(')');
            }
            else if(ch == '{'){
                stack.push('}');
            }
            else if(ch == '['){
                stack.push(']');
            }
            else if(stack.isEmpty() || stack.pop() != ch){ // 'close bracket'
                return false;
            }
        }
        return stack.isEmpty();
    }
}
