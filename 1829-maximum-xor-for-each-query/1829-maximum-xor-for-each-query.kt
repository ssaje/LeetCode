class Solution {
    fun getMaximumXor(nums: IntArray, maximumBit: Int): IntArray {
        val limit = (1 shl maximumBit) - 1
        val answer = IntArray(nums.size)
        var xored = nums.fold(0) { acc, num -> acc xor num }.inv().and(limit)
        for (i in nums.indices) {
            answer[i] = xored
            xored = xored xor nums[nums.lastIndex - i]
        }

        return answer
    }
}