class Solution {
    fun maximumCount(nums: IntArray): Int {
        var n = 0
        var p = 0
        for (num in nums) {
            if (num > 0) {
                p++
            } else if (num < 0) {
                n++
            }
        }

        return maxOf(p, n)
    }
}