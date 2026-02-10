class Solution {
    fun longestBalanced(nums: IntArray): Int {
        val n = nums.size
        var answer = 0
        for (i in 0..<n) {
            val current = mutableSetOf<Int>()
            var even = 0
            var odd = 0
            for (j in i..<n) {
                val num = nums[j]
                if (num !in current) {
                    current += num
                    if (num % 2 == 0) even++
                    else odd++
                }

                if (even == odd) {
                    answer = maxOf(answer, j - i + 1)
                }
            }
        }

        return answer
    }
}