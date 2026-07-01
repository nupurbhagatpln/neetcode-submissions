class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] countArr=new int[26];

        // count of the task
        for(char task: tasks)
        {
            countArr[task-'A']++;
        }
        // define a maxHeap
        PriorityQueue<Integer> maxHeap= new PriorityQueue<>(Collections.reverseOrder());

        // add task count to maxHeap;
        for(int c:countArr)
        {
            if(c>0)
            {
                maxHeap.offer(c);
            }
        }

        // define the Queue to store the remaining task with time interval

        Queue<int[]> q= new LinkedList<>();
        int time=0;
        // run the loop for Queue and maxHeap
        while(!maxHeap.isEmpty() || !q.isEmpty())
        {
            time++;

            if(!maxHeap.isEmpty())
            {
                int cnt=maxHeap.poll()-1;
                if(cnt>0)
                {
                    q.add(new int[]{cnt,time+n});
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
