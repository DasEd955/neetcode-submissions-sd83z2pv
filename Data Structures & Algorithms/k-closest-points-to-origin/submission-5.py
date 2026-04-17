class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        
        if len(points) == 1:
            return [points[0]]
        
        distances = list()
        for point in points:
            distance = math.sqrt(point[0]**2 + point[1]**2)
            heapq.heappush(distances, (distance * -1, point))
            if len(distances) > k:
                heapq.heappop(distances)
        
        result = list()
        for distance in distances:
            result.append(distance[1])
        
        return result