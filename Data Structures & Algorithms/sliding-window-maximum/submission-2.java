class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // max heap
        PriorityQueue<Integer> heap= new PriorityQueue<>((a,b)-> b-a);
        int n= nums.length;
        int[] ans= new int[n-k+1];
        for(int i=0;i<k;i++)
        {
            heap.add(nums[i]);
        }
        int s=0;
        for(int i=k;i<n;i++)
        {
            ans[i-k]=heap.peek();
            heap.remove(nums[s]);
            heap.add(nums[i]);
            s++;
        }

        ans[n-k]= heap.peek();

        return ans;

        
    }
}
