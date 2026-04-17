class Solution {
    public int lastStoneWeight(int[] stones) {
        
        for(int i = 0; i < stones.length; i++) {
            stones[i] *= -1;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for(int stone : stones) {maxHeap.offer(stone);}

        while(maxHeap.size() > 1) {
            int x = maxHeap.poll(), y = maxHeap.poll();
            if(x == y) {continue;}
            else if(x < y) {maxHeap.offer((y - x) * -1);}
        }

        return (maxHeap.size() != 0) ? maxHeap.peek() * -1 : 0;
    }
}
