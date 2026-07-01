class MedianFinder {
    PriorityQueue<Integer> maxH;
    PriorityQueue<Integer> minH;
    public MedianFinder() {
        maxH= new PriorityQueue<>(Collections.reverseOrder());
        minH= new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxH.isEmpty() || num<= maxH.peek())
        {
            maxH.offer(num);
        }
        else{
            minH.offer(num);
        }

        // balancing the heaps

        if(maxH.size()> minH.size()+1)
        {
            minH.offer(maxH.poll());
        }
        else if(minH.size()> maxH.size())
        {
            maxH.offer(minH.poll());
        }
        
    }
    
    public double findMedian() {
        if(maxH.size()> minH.size())
        {
            return (double)maxH.peek();
        }
        
        return (double)(maxH.peek()+ minH.peek())/2;
        
    }
}
