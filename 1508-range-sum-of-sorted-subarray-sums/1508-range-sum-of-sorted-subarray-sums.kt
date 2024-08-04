class Solution {
    companion object {
        private val MOD = 1_000_000_000 + 7
    }

    fun rangeSum(nums: IntArray, n: Int, left: Int, right: Int): Int {
        val sums = IntArray(n * (n + 1) / 2)
        var idx = 0
        for (i in 0..<n) {
            var sum = 0
            for (j in i..<n) {
                sum += nums[j]
                sums[idx++] = sum
            }
        }

        sums.sort()

        var answer = 0
        for (i in left-1..<right) {
            answer = (answer + sums[i]) % MOD
        }

        return answer
    }
}