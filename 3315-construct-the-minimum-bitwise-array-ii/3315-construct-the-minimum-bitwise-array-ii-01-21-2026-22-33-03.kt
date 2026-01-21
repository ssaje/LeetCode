class Solution {
    fun minBitwiseArray(nums: List<Int>): IntArray {
        val answer = IntArray(nums.size)
        for (i in 0..<nums.size) {
            val num = nums[i]
            answer[i] = if (num == 2) {
                -1
            } else {
                num - ((num + 1) and (-num - 1)) / 2
            }
        }

        return answer
    }
}