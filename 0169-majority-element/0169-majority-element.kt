class Solution {
    fun majorityElement(nums: IntArray): Int {
        var count = 0
        var answer = 0
        for (num in nums) {
            if (count == 0) {
                answer = num
            }

            if (num == answer) {
                ++count
            } else {
                --count
            }
        }

        return answer
    }
}