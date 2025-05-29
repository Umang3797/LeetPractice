class MedianFinder {
    
    PriorityQueue<Integer> minheap;
    PriorityQueue<Integer> maxheap;
    

    public MedianFinder() {
        minheap=new PriorityQueue<>();
        maxheap=new PriorityQueue<>((a,b)->Integer.compare(b,a));
    }
    
    public void addNum(int num) {
        if(maxheap.isEmpty() || num<=maxheap.peek()){
            maxheap.add(num);
        }else{
            minheap.add(num);
        }
        
        if(maxheap.size()>minheap.size()+1){
            minheap.add(maxheap.poll());
        }
        
        if(minheap.size()>maxheap.size()+1){
            maxheap.add(minheap.poll());
        }
        
    }
    
    public double findMedian() {
        if (maxheap.size() > minheap.size()) {
            return (double) maxheap.peek();
        } else if (minheap.size() > maxheap.size()) {
            return (double) minheap.peek();
        } else {
            return (maxheap.peek() + minheap.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */