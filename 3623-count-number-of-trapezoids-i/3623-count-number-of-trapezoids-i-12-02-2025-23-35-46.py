class Solution:
    mod = 10**9 + 7

    def countTrapezoids(self, points: List[List[int]]) -> int:
        ys = Counter(y for _, y in points)
        
        pairs = [v * (v - 1) // 2 for v in ys.values() if v > 1]
        if not pairs:
            return 0

        s = sum(pairs)
        ss = sum(p * p for p in pairs)

        return (s * s - ss) // 2 % self.mod