class Solution {
    fun maxFrequency(nums: IntArray, k: Int, numOperations: Int): Int {
        val sorted = nums.sorted()
        val counts = mutableMapOf<Int, Int>()

        val n = sorted.size
        var l = 0
        var r = 0
        var answer = 0
        for (num in sorted) {
            while (r < n && sorted[r] <= num + k) {
                counts[sorted[r]] = (counts[sorted[r]] ?: 0) + 1
                r++
            }

            while (sorted[l] < num - k) {
                counts[sorted[l]] = (counts[sorted[l]] ?: 0) - 1
                l++
            }

            answer = maxOf(answer, minOf(r - l, numOperations + (counts[num] ?: 0)))
        }

        l = 0
        r = 0
        while (r < n) {
            while (sorted[r] - sorted[l] > 2 * k) {
                l++
            }

            answer = maxOf(answer, minOf(r - l + 1, numOperations))
            r++
        }

        return answer
    }
}