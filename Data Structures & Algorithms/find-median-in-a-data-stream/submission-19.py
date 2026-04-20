class MedianFinder:

    def __init__(self):
        self.minHeap, self.maxHeap = list(), list()

    def addNum(self, num: int) -> None:

        if self.minHeap and num > self.minHeap[0]:
            heapq.heappush(self.minHeap, num)
        else:
            heapq.heappush(self.maxHeap, -num)

        if len(self.maxHeap) > len(self.minHeap) + 1:
            popped = -heapq.heappop(self.maxHeap)
            heapq.heappush(self.minHeap, popped)
        if len(self.minHeap) > len(self.maxHeap) + 1:
            popped = heapq.heappop(self.minHeap)
            heapq.heappush(self.maxHeap, -popped)

    def findMedian(self) -> float:
        if len(self.minHeap) == len(self.maxHeap):
            return (self.minHeap[0] + -self.maxHeap[0]) / 2.0
        elif len(self.minHeap) > len(self.maxHeap):
            return self.minHeap[0]
        else:
            return -self.maxHeap[0]

        