class Solution {
    fun longestSubarray(nums: IntArray): Int {
        var answer = 0
        var max = 0
        var count = 0
        for (num in nums) {
            if (max < num) {
                max = num
                count = 1
            } else if (max == num) {
                count++
            } else {
                count = 0
            }

            if (answer < count) {
                answer = count
            }
        }

        return answer
    }
}