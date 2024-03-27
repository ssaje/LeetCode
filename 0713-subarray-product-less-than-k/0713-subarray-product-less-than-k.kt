class Solution {
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        var count = 0
        var product = 1L
        var s = 0
        var answer = 0
        for (e in nums.indices) {
            product *= nums[e]
            count++

            while (product >= k && s <= e) {
                product /= nums[s]
                s++
                count--
            }

            if (product < k) {
                answer += count
            }
        }

        return answer
    }
}