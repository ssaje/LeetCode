class Solution {
    fun maximumTripletValue(nums: IntArray): Long {
        var answer = 0L
        var max = 0
        var diff = 0
        for (num in nums) {
            answer = maxOf(answer, diff.toLong() * num)
            diff = maxOf(diff, max - num)
            max = maxOf(max, num)
        }

        return answer
    }
}