class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans= new ArrayList<>();
        // sort intervals based on start [0]
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]) );
        int[] p= {intervals[0][0], intervals[0][1]};
        for(int i=1; i< intervals.length;i++)
        {
            int[] cur= {intervals[i][0], intervals[i][1]};
            //merge 
            if(p[1]>= cur[0])
            { 
                p[0]= Math.min(p[0],cur[0]);
                p[1]= Math.max(p[1],cur[1]);
            }
            // nomerge 
            else{
                ans.add(p);
                p=cur;
            }
        }

        ans.add(p);
        return ans.toArray(new int[ans.size()][]);
        
    }
}
