class MyCalendarTwo() {
    private val bookings = mutableListOf<Pair<Int, Int>>()

    fun book(start: Int, end: Int): Boolean {
        val booking = start to end
        for (i in bookings.indices) {
            val overlapped = booking intersect bookings[i] ?: continue

            for (j in i+1..bookings.lastIndex) {
                if (overlapped intersect bookings[j] != null) {
                    return false
                }
            }
        }

        bookings += booking

        return true
    }

    private infix fun Pair<Int, Int>.intersect(other: Pair<Int, Int>): Pair<Int, Int>? {
        if (this.first >= other.second || this.second <= other.first) {
            return null
        }

        return max(this.first, other.first) to min(this.second, other.second)
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * var obj = MyCalendarTwo()
 * var param_1 = obj.book(start,end)
 */