class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap= new PriorityQueue<>((a,b)-> b-a);

        for(int n:nums)
        {
            minHeap.offer(n);
        }
        while(k>1)
        {
            minHeap.poll();
            k--;
        }

        return minHeap.peek();
        
    }
}
