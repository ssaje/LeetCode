class Solution:
    def numberOfBeams(self, bank: List[str]) -> int:
        previous = 0
        answer = 0
        for row in bank:
            current = 0
            for ch in row:
                if ch == '1':
                    current += 1

            answer += current * previous
            if current > 0:
                previous = current

        return answer