class Solution {
    fun repairCars(ranks: IntArray, cars: Int): Long {
        val sorted = ranks.sorted()
        fun isPossible(time: Long): Boolean {
            var rest = cars
            for (rank in sorted) {
                rest -= sqrt(time.toDouble() / rank).toInt()
                if (rest <= 0) {
                    return true
                }
            }

            return false
        }

        var l = 1L
        var r = cars.toLong() * cars * ranks.min() + 1
        while (l < r) {
            val m = l + (r - l) / 2
            if (isPossible(m)) {
                r = m
            } else {
                l = m + 1
            }
        }

        return r
    }
}