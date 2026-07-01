class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap= new PriorityQueue<>((a,b)-> (b-a));

        for(int s:stones)
        {
            maxHeap.add(s);
        }

        while(maxHeap.size()>1)
        {
            int a= maxHeap.poll();
            if(!maxHeap.isEmpty())
            {
                int b= maxHeap.poll();
                if(a!=b)
                {
                    maxHeap.add(a-b);
                }
            }
        }

        return maxHeap.isEmpty()? 0:maxHeap.peek();
        
    }
}
