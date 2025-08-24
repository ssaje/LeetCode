class Solution {
    fun longestSubarray(nums: IntArray): Int {
        val counts = IntArray(2)
        var answer = 0
        var isDeleted = false
        for (num in nums) {
            if (num == 0) {
                counts[1] = counts[0]
                counts[0] = 0
                isDeleted = true
            } else {
                counts[0]++
                counts[1]++
                answer = maxOf(answer, counts[1])
            }
        }

        return if (isDeleted) answer else counts[0] - 1
    }
}