/*
937. Reorder Log Files
*/

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        if(logs==null || logs.length==0) return null;

        Arrays.sort(logs, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                String[] str1 = s1.split(" ", 2);
                String[] str2 = s2.split(" ", 2);

                //check if letter-logs/digis-logs
                boolean s1Digit = Character.isDigit(str1[1].charAt(0));
                boolean s2Digit = Character.isDigit(str2[1].charAt(0));
                if(s1Digit && s2Digit) return 0;
                if(!s1Digit && s2Digit) return -1;
                if(s1Digit && !s2Digit) return 1;

                //both letter-logs
                int comp = str1[1].compareTo(str2[1]);
                if(comp != 0) return comp;

                return str1[0].compareTo(str2[0]); //compare Identifiers
            }
        });
        return logs;
    }
}/*
Time Complexity: O(NlogN)
Space Complexity: O(N)
: Every time when we perform split operation on one of the Strings,
  we're allocating new space for that string.
*/
