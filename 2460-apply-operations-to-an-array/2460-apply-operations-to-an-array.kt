class Solution {
    fun applyOperations(nums: IntArray): IntArray {
        val answer = IntArray(nums.size) { nums[it] }        
        for (i in 1..<answer.size) {
            if (answer[i] == answer[i - 1]) {
                answer[i - 1] *= 2
                answer[i] = 0
            }
        }

        var i = 0
        for (j in 0..<answer.size) {
            if (answer[j] > 0) {
                answer[i] = answer[j]
                if (i != j) {
                    answer[j] = 0
                }

                i++
            }
        }

        return answer
    }
}