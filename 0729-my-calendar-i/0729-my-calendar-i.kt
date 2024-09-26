class MyCalendar() {
    private val bookings = mutableListOf<Pair<Int, Int>>()

    fun book(start: Int, end: Int): Boolean {
        for ((s, e) in bookings) {
            if ((s <= start && start < e) || (s < end && end <= e) || (s <= start && end <= e) || (start <= s && e <= end)) {
                return false
            }
        }

        bookings += start to end

        return true
    }

}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * var obj = MyCalendar()
 * var param_1 = obj.book(start,end)
 */