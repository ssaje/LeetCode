class Solution {
    fun minProductSum(nums1: IntArray, nums2: IntArray): Int {
        val sorted1 = nums1.sorted()
        val sorted2 = nums2.sorted()

        val n = nums1.size
        var answer = 0
        for (i in 0..<n) {
            answer += sorted1[i] * sorted2[n - 1 - i]
        }

        return answer
    }
}