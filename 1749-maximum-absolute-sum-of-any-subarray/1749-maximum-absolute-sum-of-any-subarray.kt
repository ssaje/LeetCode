class Solution {
    fun maxAbsoluteSum(nums: IntArray): Int {
        var answer = 0
        var min = 0
        var max = 0
        var sum = 0
        for (num in nums) {
            sum += num
            answer = maxOf(answer, (sum - min).absoluteValue, (sum - max).absoluteValue)
            min = minOf(min, sum)
            max = maxOf(max, sum)
        }

        return answer
    }
}