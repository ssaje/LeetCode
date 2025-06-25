class Solution {
    fun kthSmallestProduct(nums1: IntArray, nums2: IntArray, k: Long): Long {
        fun count(num: Long, target: Long): Int {
            var l = 0
            var r = nums2.size - 1
            var answer = 0
            while (l <= r) {
                val m = l + (r - l) / 2
                val prod = nums2[m] * num

                if ((num >= 0 && prod <= target) || (num < 0 && prod > target)) {
                    l = m + 1
                } else {
                    r = m - 1
                }
            }

            return if (num >= 0) l else nums2.size - l
        }

        var l = -1e10.toLong()
        var r = -l
        var answer = 0L
        while (l <= r) {
            val m = l + (r - l) / 2
            var sum = 0L
            for (num in nums1) {
                sum += count(num.toLong(), m)
            }

            if (sum < k) {
                l = m + 1
            } else {
                r = m - 1
                answer = m
            }
        }

        return answer
    }
}