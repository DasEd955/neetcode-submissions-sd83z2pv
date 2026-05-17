class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        visited, adj = defaultdict(int), defaultdict(list)

        for p in prerequisites:
            adj[p[0]].append(p[1])

        def dfs(course: int) -> bool:
            if visited[course] == 1:
                return False
            if visited[course] == 2:
                return True
            visited[course] = 1
            for neighbor in adj[course]:
                if not dfs(neighbor):
                    return False
            visited[course] = 2
            return True
        
        for course in range(numCourses):
            if not dfs(course):
                return False
        return True

