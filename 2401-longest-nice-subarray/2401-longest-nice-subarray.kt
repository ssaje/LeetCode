class Solution {
    fun longestNiceSubarray(nums: IntArray): Int {
        var bits = 0
        var s = 0
        var answer = 0
        for (e in nums.indices) {
            while (nums[e] and bits != 0) {
                bits -= nums[s++]
            }

            bits += nums[e]
            answer = maxOf(answer, e - s + 1)
        }

        return answer
    }
}