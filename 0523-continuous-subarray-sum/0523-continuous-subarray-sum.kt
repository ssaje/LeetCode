class Solution {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        val indexesByRemainder = mutableMapOf<Int, Int>(0 to -1)

        var sum = 0
        for (i in nums.indices) {
            val num = nums[i]
            sum = (sum + num) % k

            val index = indexesByRemainder[(k - sum) % k]
            if (index != null && i - index > 1) {
                return true
            }

            indexesByRemainder.putIfAbsent(i, sum)
        }

        return false
    }
}