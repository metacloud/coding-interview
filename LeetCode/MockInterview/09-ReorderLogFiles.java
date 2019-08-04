/*
937. Reorder Log Files
*/

class Solution {
    public String[] reorderLogFiles(String[] logs){
        
        Arrays.sort(logs, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                
                String[] str1 = s1.split(" ", 2);
                String[] str2 = s2.split(" ", 2);     
                boolean isDigit1 = Character.isDigit(str1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(str2[1].charAt(0));
                
                if(isDigit1==true && isDigit2==true) return 0;
                if(isDigit1==true && isDigit2==false) return 1;
                if(isDigit1==false && isDigit2==true) return -1;
                
                //isDigit1==false && isDigit2==false
                //we need to compare 
                int comp = (str1[1].compareTo(str2[1]));
                if(comp != 0){
                    return comp;
                }
                return str1[0].compareTo(str2[0]);
            }  
        });
        return logs;
    }
}


class Solution {
    public String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] str1 = s1.split(" ", 2);
                String[] str2 = s2.split(" ", 2);
                if (Character.isDigit(str1[1].charAt(0)) && Character.isDigit(str2[1].charAt(0))) return 0;
                if (Character.isLetter(str1[1].charAt(0)) && Character.isDigit(str2[1].charAt(0))) return -1;
                if (Character.isDigit(str1[1].charAt(0)) && Character.isLetter(str2[1].charAt(0))) return 1;

                if (str1[1].equals(str2[1])){ //need to comparer identifier
                    return str1[0].compareTo(str2[0]);
                }
                return str1[1].compareTo(str2[1]);
            }
        });
        return logs;
    }
}