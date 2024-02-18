class Solution {
    fun mostBooked(n: Int, meetings: Array<IntArray>): Int {
        val counts = IntArray(n)
        val rooms = PriorityQueue<Int>()
        val openings = PriorityQueue<Pair<Long, Int>> { a, b ->
            if (a.first != b.first) {
                a.first.compareTo(b.first)
            } else {
                a.second - b.second
            }
        }

        repeat(n) { rooms.add(it) }

        val sorted = meetings.sortedBy { it[0] }
        var max = 0
        for ((start, end) in sorted) {
            while (openings.isNotEmpty()) {
                val opening = openings.peek()
                if (start < opening.first) {
                    break
                }

                rooms.add(opening.second)
                openings.remove()
            }

            if (rooms.isEmpty()) {
                val (t, room) = openings.remove()
                openings.add(t + end - start to room)
                max = max.coerceAtLeast(++counts[room])
            } else {
                val room = rooms.remove()
                openings.add(end.toLong() to room)
                max = max.coerceAtLeast(++counts[room])
            }
        }

        return counts.indexOfFirst { it == max }
    }
}