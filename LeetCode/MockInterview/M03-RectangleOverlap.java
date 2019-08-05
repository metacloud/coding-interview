/*
836. Rectangle Overlap
*/

class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        
        //easy to see
        //bottom-left (x1,y1) , (a1,b1) , top-right  (x2,y2), (a2,b2)
        int x1=rec1[0], y1=rec1[1], x2=rec1[2], y2=rec1[3];
        int a1=rec2[0], b1=rec2[1], a2=rec2[2], b2=rec2[3];
        
        // left - right - bottom - top
        if(a2<=x1 || x2<=a1 || b2<=y1 || y2<=b1) return false;
        
        return true;
    }
}