class Solution {
    fun largestPerimeter(nums: IntArray): Int {
        val sorted = nums.sorted()
        for (i in sorted.size - 1 downTo 2) {
            if (sorted[i] < sorted[i - 1] + sorted[i - 2]) {
                return sorted[i] + sorted[i - 1] + sorted[i - 2]
            }
        }

        return 0
    }
}