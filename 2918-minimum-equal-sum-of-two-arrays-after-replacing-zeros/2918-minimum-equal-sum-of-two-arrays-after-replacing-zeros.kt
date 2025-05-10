class Solution {
    fun minSum(nums1: IntArray, nums2: IntArray): Long {
        var zero1 = 0
        var zero2 = 0
        var sum1 = 0L
        var sum2 = 0L
        for (num in nums1) {
            if (num == 0) {
                zero1++
                sum1++
            } else {
                sum1 += num
            }
        }

        for (num in nums2) {
            if (num == 0) {
                zero2++
                sum2++
            } else {
                sum2 += num
            }
        }

        return when {
            sum1 == sum2 -> sum1
            sum1 < sum2 -> {
                if (zero1 == 0) -1
                else sum2
            }
            else -> {
                if (zero2 == 0) -1
                else sum1
            }
        }
    }
}