class Solution:
    def mostBooked(self, n: int, meetings: List[List[int]]) -> int:
        unused, used = list(range(n)), []
        counts = [0] * n

        for start, end in sorted(meetings):
            while used and used[0][0] <= start:
                _, room = heappop(used)
                heappush(unused, room)

            if unused:
                room = heappop(unused)
                heappush(used, (end, room))
            else:
                used_end, room = heappop(used)
                duration = end - start
                heappush(used, (used_end + duration, room))

            counts[room] += 1

        return counts.index(max(counts))
