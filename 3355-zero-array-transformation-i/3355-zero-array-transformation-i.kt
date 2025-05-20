class Solution {
    fun isZeroArray(nums: IntArray, queries: Array<IntArray>): Boolean {
        val diffs = IntArray(100_000 + 1)
        for ((l, r) in queries) {
            diffs[l]++
            diffs[r + 1]--
        }

        var acc = 0
        for (i in nums.indices) {
            acc += diffs[i]
            if (acc < nums[i]) {
                return false
            }
        }

        return true
    }
}