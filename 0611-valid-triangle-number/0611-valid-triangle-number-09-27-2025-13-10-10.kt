class Solution {
    fun triangleNumber(nums: IntArray): Int {
        val sorted = nums.filter { it != 0 }.sorted()

        fun upperBound(e: Int, target: Int): Int {
            var l = 0
            var r = e
            while (l < r) {
                val m = l + (r - l) / 2
                if (sorted[m] <= target) l = m + 1
                else r = m
            }

            return l
        }

        var answer = 0
        for (i in 2..<nums.size) {
            for (j in 1..<i) {
                // sorted[k] > sorted[i] - sorted[j]
                val k = upperBound(j, sorted[i] - sorted[j])
                answer += j - k
            }
        }

        return answer
    }
}