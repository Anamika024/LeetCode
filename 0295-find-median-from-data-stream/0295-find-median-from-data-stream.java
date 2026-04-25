class MedianFinder {
    PriorityQueue<Integer> low;//max-heap
    PriorityQueue<Integer> high;//min heap

    public MedianFinder() {
        low = new PriorityQueue<>((a, b)-> b-a);
        high = new PriorityQueue<>();

    }
    
    public void addNum(int num) {
        low.offer(num);
        high.offer(low.poll());
        if(high.size()>low.size()) {
            low.offer(high.poll());
        }
    }
    
    public double findMedian() {
        if(low.size()>high.size()) {
            return (double) low.peek();
        }
        return (double)(low.peek()+high.peek())/2.0;


    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */