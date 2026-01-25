class Solution {
    fun minimumDifference(nums: IntArray, k: Int): Int {
        val sorted = nums.sorted()
        return minOf(sorted[k - 1] - sorted[0], sorted[sorted.size - 1] - sorted[sorted.size - k])
    }
}