class Solution {
    fun maximumTotalDamage(power: IntArray): Long {
        val sorted = power.sorted()
        
        var count = 1
        val ps = IntArray(sorted.size)
        val sums = LongArray(sorted.size)

        ps[0] = sorted[0]
        sums[0] = sorted[0].toLong()

        for (i in 1..<sorted.size) {
            val currentPower = sorted[i]
            val p = ps[count - 1]
            if (currentPower == p) {
                sums[count - 1] += currentPower
            } else {
                ps[count] = currentPower
                sums[count] = currentPower.toLong()
                count++
            }
        }

        val dp = LongArray(count)
        dp[0] = sums[0]

        var answer = dp[0]
        var j = -1
        for (i in 1..<count) {
            while (j + 1 < i && ps[j + 1] < ps[i] - 2) j++

            dp[i] = sums[i]
            if (j != -1) dp[i] += dp[j]
            dp[i] = maxOf(dp[i], dp[i - 1])

            answer = maxOf(answer, dp[i])
        }

        return answer
    }
}