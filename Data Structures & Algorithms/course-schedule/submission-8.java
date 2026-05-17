class Solution {

    private Map<Integer, Integer> visited = new HashMap<>();
    private Map<Integer, ArrayList<Integer>> adj = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int[] p : prerequisites) {
            adj.putIfAbsent(p[0], new ArrayList<>());
            adj.get(p[0]).add(p[1]);
        }

        for(int course = 0; course < numCourses; course++) {
            if(dfs(course) == false) {return false;}
        }
        return true;
    }

    private boolean dfs(int course) {
        if(visited.getOrDefault(course, 0) == 1) {return false;}
        if(visited.getOrDefault(course, 0) == 2) {return true;}
        
        visited.put(course, 1);
        for(int neighbor : adj.getOrDefault(course, new ArrayList<>())) {
            if(dfs(neighbor) == false) {return false;}
        }
        visited.put(course, 2);
        return true;
    }
}
