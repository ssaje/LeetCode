class Solution {
    fun findKDistantIndices(nums: IntArray, key: Int, k: Int): List<Int> {
        val answer = mutableSetOf<Int>()
        for (i in nums.indices) {
            if (nums[i] == key) {
                answer += maxOf(i-k, 0)..minOf(i+k, nums.size - 1)
            }
        }

        return answer.sorted()
    }
}