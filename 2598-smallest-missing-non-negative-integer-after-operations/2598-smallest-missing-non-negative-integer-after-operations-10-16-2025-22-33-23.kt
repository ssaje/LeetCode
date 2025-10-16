class Solution {
    fun findSmallestInteger(nums: IntArray, value: Int): Int {
        val counts = IntArray(value)
        for (num in nums) {
            counts[Math.floorMod(num, value)]++
        }

        val min = counts.min()
        for (i in counts.indices) {
            counts[i] -= min
            if (counts[i] == 0) return min * value + i
        }

        return -1
    }
}