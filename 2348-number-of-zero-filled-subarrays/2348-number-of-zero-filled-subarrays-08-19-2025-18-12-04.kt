class Solution {
    fun zeroFilledSubarray(nums: IntArray): Long {
        var answer = 0L
        var l = -1
        for (r in nums.indices) {
            if (nums[r] != 0) {
                l = r
                continue
            }

            answer += r - l
        }

        return answer
    }
}