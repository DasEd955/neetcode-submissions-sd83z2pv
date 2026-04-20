# Interview-Ready Solution

class Twitter:

    def __init__(self):
        self.count = 0
        self.tweets = defaultdict(list)
        self.following = defaultdict(set)

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.tweets[userId].append([self.count, tweetId])
        if len(self.tweets[userId]) > 10:
            self.tweets[userId].pop(0)
        self.count -= 1

    def getNewsFeed(self, userId: int) -> List[int]:
        result, minHeap = list(), list()

        self.following[userId].add(userId)

        for followeeId in self.following[userId]:
            if followeeId in self.tweets:
                index = len(self.tweets[followeeId]) - 1
                count, tweetId = self.tweets[followeeId][index]
                minHeap.append([count, tweetId, followeeId, index - 1])
        
        heapq.heapify(minHeap)

        while minHeap and len(result) < 10:
            count, tweetId, followeeId, index = heapq.heappop(minHeap)
            result.append(tweetId)
            if index >= 0:
                count, tweetId = self.tweets[followeeId][index]
                heapq.heappush(minHeap, [count, tweetId, followeeId, index - 1])
        
        return result

    def follow(self, followerId: int, followeeId: int) -> None:
        if followerId != followeeId:
            self.following[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followeeId in self.following[followerId]:
            self.following[followerId].remove(followeeId)
        
