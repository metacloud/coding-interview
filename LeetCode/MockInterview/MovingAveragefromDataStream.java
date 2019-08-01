/*
346. Moving Average from Data Stream
*/

class MovingAverage {

    Queue<Integer> queue;
    int size;
    int sum;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        this.size = size;
        this.sum = 0;
    }
    
    public double next(int val) {
        queue.add(val);
        sum += val; 
            
        if(queue.size() > size){
            sum = sum - queue.poll();
        }
        
        return (double)sum / queue.size();        
    }
}
/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
