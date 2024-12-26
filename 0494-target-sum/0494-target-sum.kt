class Solution {
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        fun dfs(index: Int, acc: Int): Int {
            if (index == nums.size) {
                return if (acc == target) {
                    1
                } else {
                    0
                }
            }

            return dfs(index + 1, acc + nums[index]) + dfs(index + 1, acc - nums[index])
        }

        return dfs(0, 0)
    }
}