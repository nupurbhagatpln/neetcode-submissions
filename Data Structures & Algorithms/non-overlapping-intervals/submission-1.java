class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        int count=0;
        if(intervals.length<=1) return 0;

        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        int end= intervals[0][1];

        for(int i=1;i<intervals.length;i++)
        {
            if(end<=intervals[i][0]) // non overlapping
            {
                end= intervals[i][1];
            }
            else{
                count++;
                end= Math.min(end, intervals[i][1]);
            }
        }        
        return count;
    }
}
