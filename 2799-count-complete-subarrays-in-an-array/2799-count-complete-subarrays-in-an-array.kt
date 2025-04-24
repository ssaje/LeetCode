class Solution {
    fun countCompleteSubarrays(nums: IntArray): Int {
        var answer = 0
        val total = nums.toSet().size
        val current = mutableMapOf<Int, Int>()
        var r = 0
        for (l in nums.indices) {
            while (r < nums.size && current.size < total) {
                val num = nums[r++]
                current[num] = (current[num] ?: 0) + 1
            }

            if (current.size < total) {
                break
            } else {
                answer += nums.size - r + 1
            }

            val num = nums[l]
            current[num] = current[num]!! - 1
            if (current[num] == 0) {
                current.remove(num)
            }
        }

        return answer
    }
}