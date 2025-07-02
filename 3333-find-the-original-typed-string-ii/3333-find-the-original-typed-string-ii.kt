class Solution {
    fun possibleStringCount(word: String, k: Int): Int {
        val n = word.length
        if (n < k) return 0
        else if (n == k) return 1

        var fs = mutableListOf<Int>()
        var count = 1
        for (i in 1..<n) {
            if (word[i - 1] == word[i]) {
                count++
            } else {
                fs += count
                count = 1
            }
        }
        fs += count

        var answer = 1L
        for (f in fs) {
            answer = (answer * f) % MOD
        }

        if (fs.size >= k) return answer.toInt()

        var dp = IntArray(k)
        dp[0] = 1

        var prefixSums = IntArray(k) { 1 }
        for (i in fs.indices) {
            val nDp = IntArray(k)
            for (j in 1..<k) {
                nDp[j] = prefixSums[j - 1]
                if (j - fs[i] - 1 >= 0) {
                    nDp[j] = (nDp[j] - prefixSums[j - fs[i] - 1] + MOD) % MOD
                }
            }

            val nPrefixSums = IntArray(k)
            nPrefixSums[0] = nDp[0]
            for (j in 1..<k) {
                nPrefixSums[j] = (nPrefixSums[j - 1] + nDp[j]) % MOD
            }

            dp = nDp
            prefixSums = nPrefixSums
        }
        

        return ((answer - prefixSums[k - 1] + MOD) % MOD).toInt()
    }

    companion object {
        private const val MOD = 1_000_000_000 + 7
    }
}