class Solution {
    fun resultsArray(nums: IntArray, k: Int): IntArray {
        fun getPower(s: Int): Int {
            for (i in s+1..<s+k) {
                if (nums[i - 1] >= nums[i]) {
                    return -1
                }
            }

            return nums[s + k - 1]
        }

        return (0..nums.size-k).map { getPower(it) }.toIntArray()
    }
}