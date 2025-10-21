class Solution {
    fun maxFrequency(nums: IntArray, k: Int, numOperations: Int): Int {
        val sorted = nums.sorted()
        val counts = sorted.groupingBy { it }.eachCount()

        var answer = 0
        var l = 0
        var r = 0
        for (value in sorted[0]..sorted[sorted.size - 1]) {
            // [l, r)
            while (r < sorted.size && sorted[r] <= value + k) {
                r++
            }

            while (sorted[l] < value - k) {
                l++
            }

            answer = maxOf(answer, minOf(r - l, (counts[value] ?: 0) + numOperations))
        }

        return answer
    }
}