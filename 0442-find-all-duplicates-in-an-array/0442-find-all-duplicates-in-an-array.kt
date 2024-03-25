class Solution {
    fun findDuplicates(nums: IntArray): List<Int> {
        var answer = mutableListOf<Int>()
        for (num in nums) {
            val index = num.absoluteValue - 1
            if (nums[index] < 0) {
                answer += num.absoluteValue
            } else {
                nums[index] = -nums[index]
            }
        }

        return answer
    }
}