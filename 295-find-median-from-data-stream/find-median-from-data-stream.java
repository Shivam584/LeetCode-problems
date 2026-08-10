class MedianFinder {
    PriorityQueue<Integer> maxSt,minSt;
    int n;
    public MedianFinder() {
        maxSt = new PriorityQueue<Integer>((a,b)->{
            return Integer.compare(b,a);
        });
        minSt = new PriorityQueue<Integer>((a,b)->{
            return Integer.compare(a,b);
        });
        n=0;
    }
    
    public void addNum(int num) {
        if(maxSt.isEmpty() || num<=maxSt.peek())
            maxSt.offer(num);
        else
            minSt.offer(num);

        //rebalance

        while(maxSt.size()-minSt.size()>1)
            minSt.offer(maxSt.poll());
        
        while(minSt.size()>maxSt.size())
            maxSt.offer(minSt.poll());
        n++;
    }
    
    public double findMedian() {
        if(n%2==1)
            return (double)maxSt.peek();
        
        return ((long)maxSt.peek()+minSt.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.offerNum(num);
 * double param_2 = obj.findMedian();
 */