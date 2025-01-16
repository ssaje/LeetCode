class Solution {
    fun xorAllNums(nums1: IntArray, nums2: IntArray): Int {
        var answer = 0

        fun applyToAnswer(left: IntArray, right: IntArray) {
            if (right.size % 2 == 1) {
                for (num in left) {
                    answer = answer xor num
                } 
            }
        }   

        applyToAnswer(nums1, nums2)
        applyToAnswer(nums2, nums1)

        return answer
    }
}