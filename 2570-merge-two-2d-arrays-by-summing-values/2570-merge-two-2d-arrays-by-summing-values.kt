class Solution {
    fun mergeArrays(nums1: Array<IntArray>, nums2: Array<IntArray>): Array<IntArray> {
        var i = 0
        var j = 0
        val answer = mutableListOf<IntArray>()
        while (i < nums1.size && j < nums2.size) {
            if (nums1[i][0] == nums2[j][0]) {
                answer += intArrayOf(nums1[i][0], nums1[i][1] + nums2[j][1])
                i++
                j++
            } else if (nums1[i][0] < nums2[j][0]) {
                answer += nums1[i]
                i++
            } else {
                answer += nums2[j]
                j++
            }
        }

        while (i < nums1.size) {
            answer += nums1[i]
            i++
        }

        while (j < nums2.size) {
            answer += nums2[j]
            j++
        }

        return answer.toTypedArray()
    }
}