class Solution {
    fun findErrorNums(nums: IntArray): IntArray {
        val set = HashSet<Int>()
        var sum = 0
        var duplicated = 0
        for (num in nums) {
            sum += num
            if (num in set) {
                duplicated = num
            } else {
                set += num
            }
        }

        return intArrayOf(duplicated, nums.size * (nums.size + 1) / 2 + duplicated - sum)
    }
}