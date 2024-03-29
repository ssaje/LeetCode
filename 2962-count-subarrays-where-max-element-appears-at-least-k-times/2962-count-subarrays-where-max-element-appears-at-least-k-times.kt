class Solution {
    fun countSubarrays(nums: IntArray, k: Int): Long {
        val n = nums.size
        val max = nums.max()

        var maxCount = 0
        var s = 0
        var answer = 0L
        for (e in nums.indices) {
            if (nums[e] == max) {
                maxCount++
            }

            while (maxCount >= k && s <= e) {
                if (nums[s] == max) {
                    maxCount--
                }

                answer += n - e
                s++
            }
        }

        return answer
    }
}