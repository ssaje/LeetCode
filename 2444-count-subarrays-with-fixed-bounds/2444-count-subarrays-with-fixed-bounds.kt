class Solution {
    fun countSubarrays(nums: IntArray, minK: Int, maxK: Int): Long {
        var answer = 0L
        var lastIndex = -1
        var minIndex = -1
        var maxIndex = -1
        for (i in nums.indices) {
            val num = nums[i]
            if (num !in minK..maxK) {
                lastIndex = i
            }

            if (num == minK) {
                minIndex = i
            }
            
            if (num == maxK) {
                maxIndex = i
            }

            if (lastIndex >= minIndex || lastIndex >= maxIndex) {
                continue
            }

            answer += min(minIndex, maxIndex) - lastIndex
        }

        return answer
    }
}