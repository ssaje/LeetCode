class Solution {
    fun minimumSize(nums: IntArray, maxOperations: Int): Int {
        fun canDivide(limit: Int): Boolean {
            var operations = 0
            for (num in nums) {
                if (num <= limit) {
                    continue
                }

                operations += (num - 1) / limit
                if (operations > maxOperations) {
                    return false
                }
            }

            return true
        }

        var left = 1
        var right = nums.max()
        var answer = right
        while (left <= right) {
            val middle = left + (right - left) / 2
            if (canDivide(middle)) {
                answer = middle
                right = middle - 1
            } else {
                left = middle + 1
            }
        }

        return answer
    }
}