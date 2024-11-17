class Solution {
    fun shortestSubarray(nums: IntArray, k: Int): Int {
        var answer = Int.MAX_VALUE
        var sum = 0
        var i = 0
        for (j in nums.indices) {
            sum += nums[j]
            while (i <= j && sum >= k) {
                answer = answer.coerceAtMost(j - i + 1)
                
                sum -= nums[i]
                i++
            }
        }

        return answer.takeIf { answer != Int.MAX_VALUE } ?: -1
    }
}