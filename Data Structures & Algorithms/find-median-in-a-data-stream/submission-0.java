class MedianFinder {
    PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(!rightHeap.isEmpty() && num >= rightHeap.peek()) {
            rightHeap.add(num);
        }else{
            leftHeap.add(num);
        }
        if((leftHeap.size() - rightHeap.size()) > 1){
            rightHeap.add(leftHeap.poll());
        }
        
        if((rightHeap.size() - leftHeap.size()) > 1){
            leftHeap.add(rightHeap.poll());
        }
    }
    
    public double findMedian() {
        if(leftHeap.size() > rightHeap.size()) return (double) leftHeap.peek();
        if(rightHeap.size() > leftHeap.size()) return (double) rightHeap.peek();
        if(leftHeap.size() == rightHeap.size()) return (leftHeap.peek() + rightHeap.peek())/(double) 2;
        return 0;
     }
}
