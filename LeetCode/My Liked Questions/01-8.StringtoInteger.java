/*
8. String to Integer (atoi)
*/

class Solution {
    public int myAtoi(String str) {
        if(str==null || str.length()==0) return 0;

        int i=0;
        while(i<str.length() && str.charAt(i)==' ') i++;
        if(i==str.length()) return 0;

        int sign=1;
        if(str.charAt(i)=='-' || str.charAt(i)=='+'){
            sign = (str.charAt(i++)=='-' ? -1 : 1);
        }

        long val=0;
        while(i<str.length() && Character.isDigit(str.charAt(i))){
            val = val*10 + (str.charAt(i++)-'0');
            if(val > Integer.MAX_VALUE){
                return (sign==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE);
            }
        }
        return (int)(sign * val);
    }
}
