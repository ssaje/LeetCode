class Solution {
    fun isTrionic(nums: IntArray): Boolean {
        if (nums[0] >= nums[1]) return false

        var count = 0
        for (i in 2..<nums.size) {
            if (nums[i - 1] == nums[i]) return false

            if ((nums[i - 2] - nums[i - 1]).sign * (nums[i - 1] - nums[i]).sign < 0) {
                count++
            }
        }

        return count == 2
    }
}