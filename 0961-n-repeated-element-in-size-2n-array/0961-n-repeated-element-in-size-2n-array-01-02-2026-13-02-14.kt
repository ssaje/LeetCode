class Solution {
    fun repeatedNTimes(nums: IntArray): Int {
        val counts = IntArray(10001)
        for (num in nums) {
            counts[num]++
            if (counts[num] > 1) return num
        }

        return -1
    }
}