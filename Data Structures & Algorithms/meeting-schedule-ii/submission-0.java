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
    public int minMeetingRooms(List<Interval> intervals) {
        int [] startT= new int[intervals.size()];
        int [] endT= new int[intervals.size()];

        int i=0;
        for(Interval interval:intervals)
        {
            startT[i]=interval.start;
            endT[i]=interval.end;
            i++;
        }
        Arrays.sort(startT);
        Arrays.sort(endT);

        int count=0;
        int ans=0;
        int j=0;
        i=0;
        while(i<startT.length || j<endT.length)
        {
            if(i<startT.length && startT[i]<endT[j])
            {
                count++;
                i++;
            }
            else if(j<endT.length){
                count--;
                j++;
            }
            ans=Math.max(ans,count);
        }
        return ans;

        

    }
}
