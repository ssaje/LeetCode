class Solution {
    fun maxSum(nums: IntArray): Int {        
        var nonPositiveMax = Int.MIN_VALUE
        var answer = 0
        for (num in nums.toSet()) {
            if (num > 0) answer += num
            else nonPositiveMax = maxOf(nonPositiveMax, num)
        }

        return if (answer == 0) nonPositiveMax else answer
    }
}