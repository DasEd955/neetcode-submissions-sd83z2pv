class KthLargest {

    private int k;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        this.k = k;
        for(int num : nums) {
            this.minHeap.offer(num);
            if(this.minHeap.size() > k) {
                this.minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        this.minHeap.offer(val);
        if(this.minHeap.size() > k) {
            this.minHeap.poll();
        }
        return this.minHeap.peek();
    }
}
