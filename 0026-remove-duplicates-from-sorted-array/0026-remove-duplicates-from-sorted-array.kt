class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var k = 0
        for (num in nums) {
            if (nums[k] != num) {
                nums[++k] = num
            }
        }

        return k + 1
    }
}