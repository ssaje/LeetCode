class Solution {
    fun minPairSum(nums: IntArray): Int {
        var answer = 0
        val sorted = nums.sorted()
        for (i in 0..<sorted.size/2) {
            answer = maxOf(answer, sorted[i] + sorted[sorted.size - i - 1])
        }

        return answer
    }
}