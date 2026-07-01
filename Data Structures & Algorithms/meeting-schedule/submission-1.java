/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {

        if(intervals.size()<=1)
        {
            return true;
        }
        Collections.sort(intervals,Comparator.comparingInt(i->i.start));
        int valid= intervals.get(0).end;
        for(int i=1;i<intervals.size();i++)
        {
            if(valid<=intervals.get(i).start)
            {
                valid=intervals.get(i).end;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
