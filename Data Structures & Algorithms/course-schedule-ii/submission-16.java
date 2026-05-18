class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses], result = new int[numCourses];
        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
        Deque<Integer> queue = new ArrayDeque<>();

        for(int[] p : prerequisites) {
            adj.putIfAbsent(p[1], new ArrayList<>());
            adj.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        for(int course = 0; course < numCourses; course++) {
            if(indegree[course] == 0) {queue.offer(course);}
        }
        
        int finish = 0, i = 0;
        while(!queue.isEmpty()) {
            int course = queue.removeFirst();
            finish++;
            for(int neighbor : adj.getOrDefault(course, new ArrayList<>())) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) {queue.offer(neighbor);}
            }
            result[i++] = course; 
        }

        return (finish == numCourses) ? result : new int[0];
    }
}
