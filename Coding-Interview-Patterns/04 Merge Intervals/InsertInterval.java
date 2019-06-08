
/*
Pattern: Merge Intervals
02 Insert Interval (medium)

Given a list of non-overlapping intervals sorted by their start time,
insert a given interval at the correct position and merge all necessary intervals
to produce a list that has only mutually exclusive intervals.

Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
Output: [[1,3], [4,7], [8,12]]
Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].

# LeetCode 57 Insert Interval [Hard]
[Result]
Runtime: 1 ms, faster than 99.86% of Java online submissions for Insert Interval.
Memory Usage: 41 MB, less than 41.90% of Java online submissions for Insert Interval.
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


class InsertInterval {

  public static List<Interval> insert(List<Interval> intervals, Interval newInterval){

    List<Interval> mergedIntervals = new ArrayList<>();
    boolean added = false;

    for(Interval interval : intervals){
        if(interval.end < newInterval.start){
          mergedIntervals.add(interval);
        }
        else if(newInterval.end < interval.start){
          if(!added){
            mergedIntervals.add(newInterval);
            added = true;
          }
          mergedIntervals.add(interval);
        }
        else { //overlapping
          newInterval.start = Math.min(interval.start, newInterval.start);
          newInterval.end = Math.max(interval.end, newInterval.end);
        }
    }

    if(!added){
      mergedIntervals.add(newInterval);
    }
    return mergedIntervals;

  }/*
  Time Complexity: O(N)
  Space Complexity: O(N)
  */


  public static void main(String[] args) {
      List<Interval> input = new ArrayList<Interval>();

      input.add(new Interval(1, 3));
      input.add(new Interval(5, 7));
      input.add(new Interval(8, 12));
      System.out.print("Intervals after inserting the new interval: ");
      for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
        System.out.print("[" + interval.start + "," + interval.end + "] ");
      System.out.println();

      input = new ArrayList<Interval>();
      input.add(new Interval(1, 3));
      input.add(new Interval(5, 7));
      input.add(new Interval(8, 12));
      System.out.print("Intervals after inserting the new interval: ");
      for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
        System.out.print("[" + interval.start + "," + interval.end + "] ");
      System.out.println();

      input = new ArrayList<Interval>();
      input.add(new Interval(2, 3));
      input.add(new Interval(5, 7));
      System.out.print("Intervals after inserting the new interval: ");
      for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
        System.out.print("[" + interval.start + "," + interval.end + "] ");
      System.out.println();
  }
}



//LeetCode : Input type "2D Arrays"

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval){
        List<int[]> mergedIntervals = new ArrayList<>();
        boolean added = false;
        for(int[] interval : intervals){

          if(interval[1] < newInterval[0]){//interval.end < newInterval.start
            mergedIntervals.add(interval);
          }
          else if(interval[0] > newInterval[1]){//newInterval.end < interval.start
            if(!added){
              mergedIntervals.add(newInterval);
              added = true;
            }
            mergedIntervals.add(interval);
          }
          else{
              newInterval[0] = Math.min(interval[0], newInterval[0]);
              newInterval[1] = Math.max(interval[1], newInterval[1]);
          }
        }
        if(!added){//only if newInterval is last
          mergedIntervals.add(newInterval);
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
