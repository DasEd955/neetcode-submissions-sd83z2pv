class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        
        indegree = [0] * numCourses
        adj = defaultdict(list)
        queue = deque()
        result = list()

        for src, dst in prerequisites:
            adj[dst].append(src)
            indegree[src] += 1
        
        for course in range(numCourses):
            if indegree[course] == 0:
                queue.append(course)
        
        finish = 0
        while queue:
            course = queue.popleft()
            finish += 1
            for neighbor in adj[course]:
                indegree[neighbor] -= 1
                if indegree[neighbor] == 0:
                    queue.append(neighbor)
            result.append(course)

        return result if finish == numCourses else []
