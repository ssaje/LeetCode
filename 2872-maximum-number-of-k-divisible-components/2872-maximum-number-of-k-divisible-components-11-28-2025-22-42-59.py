class Solution:
    def maxKDivisibleComponents(self, n: int, edges: List[List[int]], values: List[int], k: int) -> int:
        g = [[] for _ in range(n)]
        for a, b in edges:
            g[a].append(b)
            g[b].append(a)

        self.answer = 0
        def dfs(u: int, p: int) -> int:
            sum = values[u] % k
            for v in g[u]:
                if v == p:
                    continue
                
                sum = (sum + dfs(v, u)) % k

            if sum == 0:
                self.answer += 1

            return sum

        dfs(0, -1)

        return self.answer