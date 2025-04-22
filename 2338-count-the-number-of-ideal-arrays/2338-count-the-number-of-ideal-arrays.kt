class Solution {
    fun idealArrays(n: Int, maxValue: Int): Int {
        val minimumPrimes = IntArray(maxValue + 1)
        for (i in 2..maxValue) {
            if (minimumPrimes[i] == 0) {
                for (j in i..maxValue step i) {
                    if (minimumPrimes[j] == 0) {
                        minimumPrimes[j] = i
                    }
                }
            }
        }

        val primeCounts = Array(maxValue + 1) { mutableListOf<Int>() }
        var max = 0
        for (i in 2..maxValue) {
            var current = i
            while (current > 1) {
                val minimumPrime = minimumPrimes[current]
                var count = 0
                while (current % minimumPrime == 0) {
                    current /= minimumPrime
                    count++
                }

                max = maxOf(max, count)
                primeCounts[i] += count
            }
        }

        val m = n + max
        val C = Array(m) { IntArray(max + 1) }
        C[0][0] = 1
        for (i in 1..<m) {
            C[i][0] = 1
            for (j in 1..min(i, max)) {
                C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD
            }
        }

        var answer = 0
        for (last in 1..maxValue) {
            var acc = 1L
            for (primeCount in primeCounts[last]) {
                acc = (acc * C[n - 1 + primeCount][primeCount]) % MOD
            }
            answer = (answer + acc.toInt()) % MOD
        }

        return answer
    }

    companion object {
        private const val MOD = 1_000_000_007
    }
}