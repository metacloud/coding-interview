
/*
Pattern: Merge Intervals
01 Merge Intervals (Medium)

Given a list of intervals,
merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.
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
    }

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
