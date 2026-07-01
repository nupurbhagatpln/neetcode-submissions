class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] cnt= new int[26];
        PriorityQueue<Integer> maxHeap= new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> q= new LinkedList<>();
        int time=0;

        for(char c:tasks)
        {
            cnt[c-'A']++;
        }

        for(int t:cnt)
        {
            if(t>0)
            {
                maxHeap.offer(t);
            }
        }
        while(!maxHeap.isEmpty() || !q.isEmpty())
        {
            time++;
            if(!maxHeap.isEmpty())
            {
                int temp= maxHeap.poll()-1;
                if(temp>0)
                {
                    q.add(new int[]{temp, time+n});
                }
            }
            if(!q.isEmpty() && q.peek()[1]==time)
            {

                maxHeap.offer(q.poll()[0]);
            }
        }
        return time;
        
    }
}
