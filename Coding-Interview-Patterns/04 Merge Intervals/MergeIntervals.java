
/*
Pattern: Merge Intervals
01 Merge Intervals (Medium)

Given a list of intervals,
merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.

# LeetCode 56. Merge Intervals [Medium]
[Result]
Runtime: 6 ms, faster than 91.52% of Java online submissions for Merge Intervals.
Memory Usage: 37.5 MB, less than 99.35% of Java online submissions for Merge Intervals.
*/


import java.util.*;

class Interval {
  int start;
  int end;

  public Interval(int start, int end){
    this.start = start;
    this.end = end;
  }
};

class MergeIntervals {

    public static List<Interval> merge(List<Interval> intervals){
        //sort all the intervals on the start time to ensure a.start <= b.start
        Collections.sort(intervals, (a, b)->Integer.compare(a.start, b.start));

        LinkedList<Interval> mergedIntervals = new LinkedList<Interval>();
        for(Interval interval : intervals){
            if(mergedIntervals.isEmpty() || mergedIntervals.getLast().end < interval.start){
                mergedIntervals.add(interval);
            } else {
              mergedIntervals.getLast().end = Math.max(mergedIntervals.getLast().end, interval.end);
            }
        }
        return mergedIntervals;
    }/*
    Time Complexity: O(NlogN)
    Space Complexity: O(N)
    */

    public static void main(String[] args) {

        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
          System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
          System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
          System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}


//LeetCode : Input type "2D Arrays"

class Solution {
  public int[][] merge(int[][] intervals) {
      if(intervals.length==0) return intervals;

      List<int []> mergedList = new ArrayList<>();
      Arrays.sort(intervals, new Comparator<int[]>(){
        @Override
        public int compare(int[] a, int[] b){
          return Integer.compare(a[0],b[0]);
        }
      });

      int startpoint = intervals[0][0];
      int endpoint = intervals[0][1];

      for(int i=0; i<intervals.length; i++){
          if(i+1>= intervals.length){
            int m[] = {startpoint, endpoint};
            mergedList.add(m);
          }
          else if(intervals[i+1][0] <= endpoint){
              endpoint = Math.max(intervals[i+1][1], endpoint);
          }
          else { //No overlapping part
              int m[] = {startpoint, endpoint};
              mergedList.add(m);
              //update
              startpoint = intervals[i+1][0];
              endpoint = intervals[i+1][1];
          }
      }
      int mergedIntervals [][] = new int[mergedList.size()][];
      return mergedList.toArray(mergedIntervals);
  }
}
