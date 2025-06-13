class Solution {
    fun minimizeMax(nums: IntArray, p: Int): Int {
        if (p == 0) return 0

        val sorted = nums.sorted()
        val n = sorted.size
        var answer = sorted[n - 1] - sorted[0]

        fun ps(limit: Int): Boolean {
            var i = 1
            var count = 0
            while (i < n) {
                if (sorted[i] - sorted[i - 1] <= limit) {
                    if (++count >= p) return true
                    
                    i += 2
                } else {
                    i++
                }
            }

            return false
        }

        var l = 0
        var r = answer
        while (l <= r) {
            val m = l + (r - l) / 2
            if (ps(m)) {
                answer = m
                r = m - 1
            } else {
                l = m + 1
            }
        }

        return answer
    }
}