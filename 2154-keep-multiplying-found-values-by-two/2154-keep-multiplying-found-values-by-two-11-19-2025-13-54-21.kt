class Solution {
    fun findFinalValue(nums: IntArray, original: Int): Int {
        var answer = original
        outer@while (true) {
            for (num in nums) {
                if (answer == num) {
                    answer *= 2
                    continue@outer
                }
            }

            break
        }

        return answer
    }
}