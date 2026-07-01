class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap= new PriorityQueue<>((a,b)->(a[0]- b[0]));
        for(int[] t:points)
        {
            int dist= ((t[0]*t[0]) + (t[1]*t[1]));
            minHeap.add(new int[]{dist, t[0], t[1]});
        }
        int[][] ans= new int[k][2];
        int i=0;
        while(k>0)
        {
            int[] temp= minHeap.poll();
            k--;
            ans[i][0]= (int)(temp[1]);
            ans[i][1]= (int)(temp[2]);
            i++;
        }
        return ans;

    }
}
