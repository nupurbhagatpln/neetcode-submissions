class Solution {


    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] ans= new int [nums.length - k+1];
        PriorityQueue<int[]> q= new PriorityQueue<>((a,b)-> b[0]-a[0]); // max heap

        int ind=0;

        for(int i=0 ;i<nums.length;i++)
        {
            q.offer(new int[]{nums[i],i});
            //  window size or excedding
            if(i>= k-1)
            {
                while(q.peek()[1]<=i-k)  // here it will exceute after k th window
                {
                    q.poll();
                }
                ans[ind++]=q.peek()[0];
            }
        }
        return ans;        
    }
}
