class Solution {
    fun minimumOperations(nums: IntArray): Int {
        var rest = 0
        val frequencies = IntArray(101)
        for (num in nums) {
            if (++frequencies[num] == 2) {
                rest++
            }
        }

        var i = 0
        var answer = 0
        while (i < nums.size) {
            if (rest == 0) {
                return answer
            }

            answer++

            for (j in 0..<3) {
                if (i >= nums.size) {
                    break
                }

                if (--frequencies[nums[i]] == 1) {
                    --rest
                }

                ++i
            }
        }

        return answer
    }
}