class Solution {
    fun countGood(nums: IntArray, k: Int): Long {
        var answer = 0L
        var sum = 0
        var l = 0
        val counts = mutableMapOf<Int, Int>()
        for (r in nums.indices) {
            sum += counts[nums[r]] ?: 0
            counts[nums[r]] = (counts[nums[r]] ?: 0) + 1

            while (l < r && sum - counts[nums[l]]!! + 1 >= k) {
                sum -= counts[nums[l]]!! - 1
                counts[nums[l]] = counts[nums[l]]!! - 1
                l++
            }

            if (sum >= k) {
                answer += l + 1
            }
        }

        return answer
    }
}