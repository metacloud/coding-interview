
/*
Pattern: Merge Intervals
02 Insert Interval (medium)

Given a list of non-overlapping intervals sorted by their start time,
insert a given interval at the correct position and merge all necessary intervals
to produce a list that has only mutually exclusive intervals.

Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
Output: [[1,3], [4,7], [8,12]]
Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].

# LeetCode 57 Insert Interval
[Result]

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
    int lastIndex= 0;
    List<Interval> mergedIntervals = new ArrayList<>();

    for(int i=0; i<intervals.size(); i++){
      if(intervals.get(i).end < newInterval.start){
          mergedIntervals.add(intervals.get(i));
      }
      else if(newInterval.start >= intervals.get(i).start && newInterval.start <= intervals.get(i).end){
        newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
        newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
      }
      else if(newInterval.start < intervals.get(i).start && intervals.get(i).start <= newInterval.end ){
        newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
        newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
      }
      else if(newInterval.end < intervals.get(i).start ){
        lastIndex = i;
        break;
      }
    }

    mergedIntervals.add(newInterval);

    if(lastIndex==0) return mergedIntervals;
    for(int i=lastIndex; i<intervals.size(); i++){
      mergedIntervals.add(intervals.get(i));
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
