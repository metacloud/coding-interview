/*
957. Prison Cells After N Days
*/

class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        
        int[] firstCycle = new int[cells.length];
        int[] tmp = new int[cells.length];
        
        for(int cycle=0; N>0; cycle++){
            
            N--;
            for(int i=1; i<cells.length-1;i++){
                tmp[i] = (cells[i-1]==cells[i+1] ? 1 : 0);
            }
            if(cycle==0){
                firstCycle = tmp.clone();
            }
            else if(Arrays.equals(firstCycle, tmp)){
                //find the length of cycle!
                //reduce N as removing repeated part
                N = N % cycle;
            }
            cells = tmp.clone();
        }
        return cells;
    }
}