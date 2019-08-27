/*
165. Compare Version Numbers
*/

class Solution {
    public int compareVersion(String version1, String version2) {
        int i=0, j=0;
        while(i<version1.length() || j<version2.length()){
            int v1=0, v2=0;
            while(i<version1.length() && version1.charAt(i)!='.'){
                v1 = v1*10 + (version1.charAt(i)-'0');
                i++;
            }
            while(j<version2.length() && version2.charAt(j)!='.'){
                v2 = v2*10 + (version2.charAt(j)-'0');
                j++;
            }
            if(v1>v2) return 1;
            if(v1<v2) return -1;
            i++; j++;
        }
        return 0;
    }
}/*
Time Complexity: O(Math.max(l1, l2))
Space Complexity: O(1)
*/
