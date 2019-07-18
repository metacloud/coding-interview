import java.util.Arrays;

public class Array {

    public int search(int[] arr, int val){
        int index = -1;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == val){
                index = i;
                break;
            }
        }
        return index;
    }

    public int[] deleteElement(int[] arr, int val){
        int index = search(arr, val);
        if(index >= 0){
            for(int i=index+1; i<arr.length; i++){
                arr[i-1] = arr[i];
            }
        }
        return Arrays.copyOf(arr, arr.length-1);
    }

    public void printAllElement(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(" " + arr[i]);
        }
    }

    public int[] addElement(int[] arr, int index, int val){
        int[] ret = new int[arr.length+1];
        for(int i=0; i<index; i++){
            ret[i] = arr[i];
        }
        ret[index] = val;
        for(int i=index+1; i<ret.length; i++){
            ret[i] = arr[i-1];
        }
        return ret;
    }
}
/*
Data Structure : Array
- Access : O(1)
- Search : O(N)
- Add : O(N)
- Delete : O(N)
*/
