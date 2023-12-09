class Solution {
    fun longestAlternatingSubarray(nums: IntArray, threshold: Int): Int {
        return generateSequence(0 to 0) {
            if (it.second < nums.size) {
                solve(nums, threshold, it.second)
            } else {
                null
            }
        }.maxOf { it.first }
    }

    private fun solve(nums: IntArray, threshold: Int, l: Int): Pair<Int, Int> {
        var r = l
        var parity = 0
        while (r < nums.size) {
            if (nums[r] % 2 != parity) {
                return r - l to r + 1 - parity
            } else if (nums[r] > threshold) {
                return r - l to r + 1
            }

            r++
            parity = 1 - parity
        }

        return r - l to r
    }
}