class Solution {
    fun canSortArray(nums: IntArray): Boolean {
        val sorted = IntArray(nums.size)
        for (i in sorted.indices) {
            sorted[i] = nums[i]
            for (j in i-1 downTo 0) {
                if (sorted[j] <= sorted[j+1]) {
                    break
                }

                if (sorted[j].countOneBits() != sorted[j+1].countOneBits()) {
                    return false
                }

                sorted[j] = sorted[j+1].also { sorted[j+1] = sorted[j] }
            }
        }

        return true
    }
}