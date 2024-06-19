class Solution {
    fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
        if (bloomDay.size < m * k) {
            return -1
        }

        var sum = 0
        val p = IntArray(bloomDay.size) { -1 }
        val c = IntArray(bloomDay.size)

        fun root(u: Int): Int {
            if (p[u] == -1) {
                return -1
            }

            if (u == p[u]) {
                return u
            }

            p[u] = root(p[u])
            return p[u]
        }

        fun merge(u: Int, v: Int) {
            val ru = root(u)
            val rv = root(v)
            if (ru == -1 || rv == -1) {
                return
            }

            sum -= c[ru] / k
            sum -= c[rv] / k
            
            p[rv] = ru
            c[ru] += c[rv]

            sum += c[ru] / k
        }

        val sorted = bloomDay.withIndex().sortedBy { it.value }
        for ((index, day) in sorted) {
            p[index] = index
            c[index] = 1
            if (k == 1) {
                sum++
            }

            if (index > 0) {
                merge(index - 1, index)
            }

            if (index + 1 < bloomDay.size) {
                merge(index, index + 1)
            }

            if (sum >= m) {
                return day
            }
        }

        return -1
    }
}