import numpy as np

class MedianFinder:

    def __init__(self):
        self.stream = list()

    def addNum(self, num: int) -> None:
        self.stream.append(num)

    def findMedian(self) -> float:
        return float(np.median(self.stream))
        