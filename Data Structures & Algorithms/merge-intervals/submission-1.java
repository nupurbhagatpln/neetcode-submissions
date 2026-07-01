class Solution {
    public int[][] merge(int[][] intervals) {

       if(intervals.length<1)   return  intervals;
        
        List<int[]> ans= new ArrayList<>();
        
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        int[] temp={intervals[0][0],intervals[0][1]};
        for(int[] interval: intervals)
        {
            if( temp !=null && temp[1]>=interval[0]) //merge
            {
                temp[0]= Math.min(temp[0],interval[0]);
                temp[1]= Math.max(temp[1],interval[1]);
            }
            else
            {
                
                ans.add(temp);
                temp=interval;
                // ans.add(in÷terval);
                
            }
        }
        if(temp!=null)  ans.add(temp);

        return ans.toArray(new int[ans.size()][]);

    

    }
}
