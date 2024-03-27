class Solution {
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        var product = 1L
        var s = 0
        var answer = 0
        for (e in nums.indices) {
            product *= nums[e]

            while (product >= k && s <= e) {
                product /= nums[s]
                s++
            }

            if (product < k) {
                answer += e - s + 1
            }
        }

        return answer
    }
}