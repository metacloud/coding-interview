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
/*
Runtime: O(2^n).
Memory: O(n). We need to remember a single state of all cells for the loop detection.

Complexity Deep Analysis:
As the cells have a fixed size, we have at most 2^6 = 64 states.
So regardless of input N, we have both space and time complexities as O(1).

The memory use is constant (cells.length) regardless of N,
In the big O notation, the constant complexity is expressed as O(1).
*/
