class Solution {
    fun sortColors(nums: IntArray): Unit {
        val counts = IntArray(3)
        for (num in nums) {
            counts[num]++
        }

        var i = 0
        for ((element, count) in counts.withIndex()) {
            repeat(count) {
                nums[i++] = element
            }
        }
    }
}