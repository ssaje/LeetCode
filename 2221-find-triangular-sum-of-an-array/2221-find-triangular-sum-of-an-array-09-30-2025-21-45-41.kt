class Solution {
    fun triangularSum(nums: IntArray): Int {
        val n = nums.size
        val answer = IntArray(n) { nums[it] }
        repeat(n-1) {
            for (i in 0..<n-it-1) {
                answer[i] = (answer[i] + answer[i + 1]) % 10
            }
        }

        return answer[0]
    }
}