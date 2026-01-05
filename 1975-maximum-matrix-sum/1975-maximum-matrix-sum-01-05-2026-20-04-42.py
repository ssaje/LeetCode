class Solution:
    def maxMatrixSum(self, matrix: List[List[int]]) -> int:
        total = 0
        min_abs = inf
        count = 0
        for row in matrix:
            for num in row:
                if num < 0:
                    count += 1
                    num = -num

                total += num
                min_abs = min(min_abs, num)

        if count % 2 == 0:
            return total

        return total - min_abs * 2