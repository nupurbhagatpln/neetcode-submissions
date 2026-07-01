class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        if(intervals.length<=1) return 0;
        int count=0;
        int end_t=intervals[0][1];
        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[i][0]>=end_t)
            {
                end_t=intervals[i][1];
            }
            else
            {
                count++;
                end_t=Math.min(end_t,intervals[i][1]);
            }
        }
        return count;
        
    }
}
