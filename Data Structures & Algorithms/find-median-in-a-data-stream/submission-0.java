class MedianFinder {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap= new PriorityQueue<>((a,b)-> b-a);
        minHeap= new PriorityQueue<>((a,b)->a-b);
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);

        if(maxHeap.size()-minHeap.size()>1 || (!minHeap.isEmpty() && maxHeap.peek()> minHeap.peek()))
        {
            minHeap.offer(maxHeap.poll());
        }
        if(minHeap.size()-maxHeap.size()>1)
        {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size()>maxHeap.size())
        {
            return (double)minHeap.peek();
        }
        else if(minHeap.size()<maxHeap.size())
        {
            return (double)maxHeap.peek();
        }
        else{
            return (((double) minHeap.peek())+ ((double)maxHeap.peek()))/2;
        }
    }
}
