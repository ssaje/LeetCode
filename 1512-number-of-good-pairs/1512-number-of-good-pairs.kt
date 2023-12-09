class Solution {
    fun numIdenticalPairs(nums: IntArray): Int {
        val counts = IntArray(101)
        for (num in nums) {
            counts[num]++
        }

        return counts.indices.sumOf {
            val count = counts[it]
            count * (count - 1) / 2
        }
    }
}