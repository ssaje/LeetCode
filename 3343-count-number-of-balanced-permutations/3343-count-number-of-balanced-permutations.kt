class Solution {
    fun countBalancedPermutations(num: String): Int {
        val freqs = IntArray(10)
        var sum = 0
        for (ch in num) {
            val digit = ch.digitToInt()
            freqs[digit]++
            sum += digit
        }

        if (sum % 2 == 1) {
            return 0
        }
        
        val halfSum = sum / 2
        val even = num.length / 2
        val odd = num.length - even

        val c = Array(odd + 1) { LongArray(odd + 1) }
        c[0][0] = 1
        for (i in 1..odd) {
            c[i][0] = 1
            c[i][i] = 1
            for (j in 1..<i) {
                c[i][j] = (c[i - 1][j - 1] + c[i - 1][j]) % MOD
            }
        }

        val dp = Array(odd + 1) { LongArray(halfSum + 1) }
        dp[0][0] = 1

        var fSum = 0
        var digitSum = 0
        for (i in 0..9) {
            fSum += freqs[i]
            digitSum += i * freqs[i]
            for (oddCnt in minOf(fSum, odd) downTo maxOf(0, fSum - even)) {
                val evenCnt = fSum - oddCnt
                for (acc in minOf(digitSum, halfSum) downTo maxOf(0, digitSum - halfSum)) {
                    var cnt = 0L
                    for (j in maxOf(0, freqs[i] - evenCnt)..minOf(freqs[i], oddCnt)) {
                        if (i * j > acc) {
                            break
                        }

                        val t = c[oddCnt][j] * c[evenCnt][freqs[i] - j] % MOD
                        cnt = (cnt + t * dp[oddCnt - j][acc - i * j]) % MOD
                    }
                    
                    dp[oddCnt][acc] = cnt
                }
            }
        }

        return dp[odd][halfSum].toInt()
    }

    companion object {
        private const val MOD = 1_000_000_000 + 7
    }
}