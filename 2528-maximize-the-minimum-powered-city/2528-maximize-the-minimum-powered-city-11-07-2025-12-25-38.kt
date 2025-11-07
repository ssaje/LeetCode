class Solution {
    fun maxPower(stations: IntArray, r: Int, k: Int): Long {
        val n = stations.size                

        fun canDivide(lower: Long): Boolean {
            val ds = LongArray(n)
            var rest = k.toLong()
            var sum = 0L
            for (i in 0..<r) {
                sum += stations[i]
            }

            for (i in 0..<n) {
                if (i - r - 1 >= 0) {
                    sum -= stations[i - r - 1] + ds[i - r - 1]
                }

                if (i + r < n) {
                    sum += stations[i + r] + ds[i + r]
                }

                if (sum >= lower) continue

                val d = lower - sum
                if (d > rest) return false

                rest -= d
                sum += d
                val e = minOf(i + r, n - 1)
                ds[e] += d
            }

            return true
        }

        var s = 0L
        var e = k.toLong()
        for (station in stations) {
            e += station
        }

        var answer = 0L
        while (s <= e) {
            val m = s + (e - s) / 2
            if (canDivide(m)) {
                s = m + 1
                answer = m
            } else {
                e = m - 1
            }
        }

        return answer
    }
}