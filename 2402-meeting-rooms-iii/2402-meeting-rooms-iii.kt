class Solution {
    fun mostBooked(n: Int, meetings: Array<IntArray>): Int {
        // room, startTime
        val emptyRooms = PriorityQueue<Pair<Int, Int>> { a, b -> a.first - b.first }
        for (i in 0..<n) {
            emptyRooms.offer(i to 0)
        }

        val sorted = meetings.sortedBy { it[0] }
        // endTime, room
        val ongoings = PriorityQueue<Pair<Int, Int>> { a, b ->
            if (a.first != b.first) a.first - b.first
            else a.second - b.second
        }
        val counts = IntArray(n)
        for (meeting in sorted) {
            while (ongoings.isNotEmpty() && ongoings.peek().first <= meeting[0]) {
                val (endTime, room) = ongoings.poll()
                emptyRooms.offer(room to endTime)
            }

            if (emptyRooms.isEmpty()) {
                val (endTime, room) = ongoings.poll()
                emptyRooms.offer(room to endTime)
            }

            val (room, startTime) = emptyRooms.poll()
            counts[room]++
            val endTime = maxOf(meeting[1], startTime + meeting[1] - meeting[0])
            ongoings.offer(endTime to room)
        }

        var answer = 0
        var max = 0
        for (i in 0..<n) {
            if (max < counts[i]) {
                max = counts[i]
                answer = i
            }
        }

        return answer
    }
}