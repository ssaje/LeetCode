class Solution {
    fun subsetXORSum(nums: IntArray): Int {
        fun solve(index: Int, acc: Int): Int {
            if (nums.size == index) {
                return acc
            }

            return solve(index + 1, acc) + solve(index + 1, acc xor nums[index])
        }

        return solve(0, 0)
    }
}