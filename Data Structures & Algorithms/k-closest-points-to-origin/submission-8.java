class Solution {

    class Pair {
        private double distance;
        private int[] point;

        public Pair(double distance, int[] point) {
            this.distance = distance;
            this.point = point;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        
        if(points.length == 1) {return points;}

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(
            (a, b) -> Double.compare(a.distance, b.distance)
        );
        for(int[] point : points) {
            maxHeap.offer(new Pair((point[0]*point[0] + point[1]*point[1]) * -1, point));
            if(maxHeap.size() > k) {maxHeap.poll();}
        }

        int[][] result = new int[k][2];
        int i = 0;
        while(!maxHeap.isEmpty()) {
            result[i++] = maxHeap.poll().point;
        }

        return result;
    }
}
