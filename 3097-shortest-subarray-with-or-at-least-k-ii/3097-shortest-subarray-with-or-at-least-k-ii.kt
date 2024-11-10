class Solution {
    fun minimumSubarrayLength(nums: IntArray, k: Int): Int {
        val counts = IntArray(32)

        fun getCurrent(): Int {
            var current = 0
            for (i in 0..<32) {
                if (counts[i] > 0) {
                    current = current or (1 shl i)
                }
            }

            return current
        }

        fun modifyCounts(num: Int, delta: Int) {
            for (i in 0..<32) {
                if (num and (1 shl i) > 0) {
                    counts[i] += delta
                }
            }
        }

        var answer = nums.size
        var s = 0
        for (e in nums.indices) {
            modifyCounts(nums[e], 1)

            while (s <= e && getCurrent() >= k) {
                answer = answer.coerceAtMost(e - s + 1)
                modifyCounts(nums[s], -1)
                s++
            }
        }

        return answer
    }
}