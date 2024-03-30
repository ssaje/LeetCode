class Solution {
    fun subarraysWithKDistinct(nums: IntArray, k: Int): Int {
        var countsByNum = mutableMapOf<Int, Int>()
        var s = 0
        var distinctCount = 0
        var prevCount = 1
        var answer = 0
        for (e in nums.indices) {
            val num = nums[e]
            countsByNum[num] = (countsByNum[num] ?: 0) + 1
            if (countsByNum[num]!! == 1) {
                distinctCount++
            }

            if (distinctCount > k) {
                countsByNum[nums[s]] = countsByNum[nums[s]]!! - 1
                distinctCount--
                s++
                prevCount = 1
            }

            if (distinctCount == k) {
                while (countsByNum[nums[s]]!! > 1) {
                    countsByNum[nums[s]] = countsByNum[nums[s]]!! - 1
                    s++
                    prevCount++
                }

                answer += prevCount
            }
        }

        return answer
    }
}