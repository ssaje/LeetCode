class Solution {
    fun smallestDistancePair(nums: IntArray, k: Int): Int {
        val sorted = nums.sorted()

        fun getCount(threshold: Int): Int {
            var count = 0
            var i = 0
            var max = 0
            for (j in 1..sorted.lastIndex) {
                while (sorted[j] - sorted[i] > threshold) {
                    i++
                }

                count += j - i
            }

            return count
        }

        var left = 0
        var right = sorted.last() - sorted.first()
        while (left < right) {
            val mid = left + (right - left) / 2
            if (getCount(mid) < k) {
                left = mid + 1
            } else {
                right = mid
            }
        }

        return right
    }
}