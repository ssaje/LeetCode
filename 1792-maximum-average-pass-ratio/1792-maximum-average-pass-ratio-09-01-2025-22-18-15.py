class Solution:
    def maxAverageRatio(self, classes: List[List[int]], extraStudents: int) -> float:
        def key(p: int, t: int):
            return p / t - (p + 1) / (t + 1)

        heap = [(key(p, t), p, t) for p, t in classes]
        heapq.heapify(heap)

        for _ in range(extraStudents):
            _, p, t = heapq.heappop(heap)
            heapq.heappush(heap, (key(p + 1, t + 1), p + 1, t + 1))

        return sum(p / t for _, p, t in heap) / len(classes)
