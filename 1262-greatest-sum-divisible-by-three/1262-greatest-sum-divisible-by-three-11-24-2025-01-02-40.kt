class Solution {
    fun maxSumDivThree(nums: IntArray): Int {
        var rs = intArrayOf(0, Int.MIN_VALUE, Int.MIN_VALUE)
        for (num in nums) {
            val ns = rs.copyOf()
            for (i in 0..<3) {
                val j = (i + num % 3) % 3
                ns[j] = maxOf(ns[j], rs[i] + num)
            }

            rs = ns
        }

        return rs[0]
    }
}