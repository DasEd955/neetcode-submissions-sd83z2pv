class Pair {

    private int remainingTime;
    private int nextAvailableTime;

    public Pair(int remainingTime, int nextAvailableTime) {
        this.remainingTime = remainingTime;
        this.nextAvailableTime = nextAvailableTime;
    }

}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        HashMap<Character, Integer> count = new HashMap<>();
        for(char task : tasks) {
            count.put(task, 1 + count.getOrDefault(task, 0));
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for(int freq : count.values()) {
            maxHeap.offer(-freq);
        }

        int time = 0;
        Deque<Pair> cooldown = new ArrayDeque<>();

        while(!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            time++;

            if(maxHeap.isEmpty()) {
                time = cooldown.peekFirst().nextAvailableTime;
            }
            else {
                int cnt = 1 + maxHeap.poll();
                if(cnt != 0) {
                    cooldown.offer(new Pair(cnt, time + n));
                }
            }

            if(!cooldown.isEmpty() && cooldown.peekFirst().nextAvailableTime == time) {
                maxHeap.offer(cooldown.poll().remainingTime);
            }
        }

        return time;

        //System.out.println(maxHeap);
        //return 0;
    }
}
