class Solution {
    fun minOperations(nums: IntArray, k: Int): Int {
        var answer = 0
        var w = 1
        for (i in 0..<31) {
            var zeros = 0
            var ones = 0
            for (num in nums) {
                if (num and w > 0) {
                    ones++
                }
            }

            when (k and w) {
                0 -> {
                    if (ones % 2 == 1) {
                        answer++
                    }
                }

                else -> {
                    if (ones % 2 == 0) {
                        answer++
                    }
                }
            }

            w = w shl 1
        }

        return answer
    }
}