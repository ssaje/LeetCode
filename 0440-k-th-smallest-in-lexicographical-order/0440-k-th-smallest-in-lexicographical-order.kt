class Solution {
    fun findKthNumber(n: Int, k: Int): Int {
        var answer = 1
        var r = k - 1
        val limit = (n + 1).toLong()

        fun getCount(m: Int): Int {
            var s = m.toLong()
            var e = (m + 1).toLong()
            var count = 0L
            
            while (s <= n) {
                count += e - s
                s *= 10
                e = min(e * 10, limit)
            }

            return count.toInt()
        }

        while (r > 0) {
            val count = getCount(answer)
            if (count > r) {
                r--
                answer *= 10
            } else {
                r -= count
                answer++
            }
        }

        return answer
    }
}