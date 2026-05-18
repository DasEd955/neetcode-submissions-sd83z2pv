class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
        Deque<Integer> queue = new ArrayDeque<>();

        for(int[] p : prerequisites) {
            adj.putIfAbsent(p[0], new ArrayList<>());
            adj.get(p[0]).add(p[1]);
            indegree[p[1]]++;
        }

        for(int course = 0; course < numCourses; course++) {
            if(indegree[course] == 0) {queue.offer(course);}
        }

        int finish = 0;
        while(!queue.isEmpty()) {
            int course = queue.removeFirst();
            finish++;
            for(int neighbor : adj.getOrDefault(course, new ArrayList<>())) {
                indegree[neighbor] -= 1;
                if(indegree[neighbor] == 0) {queue.offer(neighbor);}
            }
        }

        return finish == numCourses;
    }
}
