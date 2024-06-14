class Solution {
    fun minIncrementForUnique(nums: IntArray): Int {
        val max = nums.max()
        val counts = IntArray(max + 1)
        for (num in nums) {
            counts[num]++
        }

        var answer = 0
        var sum = 0
        for (i in 0..max) {
            sum = (sum + counts[i] - 1).coerceAtLeast(0)
            answer += sum
        }

        return answer + (sum.toLong() * (sum - 1) / 2).toInt()
    }
}