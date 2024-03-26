class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        val n = nums.size
        var hasOne = false
        for (i in nums.indices) {
            if (nums[i] == 1) {
                hasOne = true
            } else if (nums[i] !in 1..n) {
                nums[i] = 1
            }
        }

        if (!hasOne) {
            return 1
        }

        for (num in nums) {
            val absoluteValue = num.absoluteValue
            if (absoluteValue == n) {
                nums[0] = 0
            } else {
                nums[absoluteValue] = -nums[absoluteValue].absoluteValue
            }
        }

        for (i in 1..nums.lastIndex) {
            if (nums[i] > 0) {
                return i
            }
        }

        if (nums[0] > 0) {
            return n
        }

        return n + 1
    }
}