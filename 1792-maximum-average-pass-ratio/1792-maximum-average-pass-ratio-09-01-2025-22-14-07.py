class Solution:
    def maxAverageRatio(self, classes: List[List[int]], extraStudents: int) -> float:
        def key(p: int, t: int):
            return p / t - (p + 1) / (t + 1)

        heap = []
        for p, t in classes:
            heap.append((key(p, t), p, t))

        heapq.heapify(heap)

        for _ in range(extraStudents):
            k, p, t = heapq.heappop(heap)
            heapq.heappush(heap, (key(p + 1, t + 1), p + 1, t + 1))

        ratio_sum = sum(p / t for _, p, t in heap)
        return ratio_sum / len(classes)
