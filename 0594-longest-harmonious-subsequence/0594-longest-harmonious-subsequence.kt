class Solution {
    fun findLHS(nums: IntArray): Int {
        val sorted = nums.sorted()
        var r = 0
        var answer = 0
        for (l in sorted.indices) {
            val num = sorted[l]
            while (r + 1 < sorted.size && sorted[r + 1] <= num + 1) {
                r++
            }

            if (num + 1 == sorted[r]) {
                answer = maxOf(answer, r - l + 1)
            }

            if (r + 1 == sorted.size) break
        }

        return answer
    }
}