class Solution {
    fun minimumOperations(nums: IntArray): Int {
        var answer = 0
        for (num in nums) {
            answer += minOf(num % 3, 3 - num % 3)
        }

        return answer
    }
}