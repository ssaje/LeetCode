class Solution {
    fun minBitwiseArray(nums: List<Int>): IntArray {
        var answer = IntArray(nums.size)
        for (i in 0..<nums.size) {
            answer[i] = -1
            for (j in 0..<nums[i]) {
                if (j or (j + 1) == nums[i]) {
                    answer[i] = j
                    break
                }
            }
        }

        return answer
    }
}