class Solution:
    def maxAverageRatio(self, classes: List[List[int]], extraStudents: int) -> float:
        heap = [(p / t - (p + 1) / (t + 1), p, t) for p, t in classes]
        heapq.heapify(heap)

        for _ in range(extraStudents):
            _, p, t = heapq.heappop(heap)
            heapq.heappush(heap, ((p + 1) / (t + 1) - (p + 2) / (t + 2), p + 1, t + 1))

        return sum(p / t for _, p, t in heap) / len(classes)
