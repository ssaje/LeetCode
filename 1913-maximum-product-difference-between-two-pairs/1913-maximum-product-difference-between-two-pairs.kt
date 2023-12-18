class Solution {
    fun maxProductDifference(nums: IntArray): Int {
        val sorted = nums.sorted()
        return sorted.last() * sorted[sorted.lastIndex - 1] - sorted[0] * sorted[1]
    }
}