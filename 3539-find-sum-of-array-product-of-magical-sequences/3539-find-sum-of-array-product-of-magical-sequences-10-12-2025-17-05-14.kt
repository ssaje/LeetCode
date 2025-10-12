class Solution {
    fun magicalSum(m: Int, k: Int, nums: IntArray): Int {
        val comb = Array(m + 1) { LongArray(m + 1) }
        comb[0][0] = 1
        for (i in 1..m) {
            comb[i][0] = 1
            for (j in 1..i) {
                comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % MOD
            }
        }

        // 특정 숫자는 m개까지 고를 수 있음 ㅇㅋ
        val n = nums.size
        val pows = Array(n) { LongArray(m + 1) }
        for (i in 0..<n) {
            pows[i][0] = 1
            for (j in 1..m) {
                pows[i][j] = (pows[i][j - 1] * nums[i]) % MOD
            }
        }

        // cache[n][m][k][carry]
        // carry는 최대 m개
        val cache = Array(n + 1) {
            Array(m + 1) {
                Array(k + 1) {
                    LongArray(m + 1) { -1 }
                }
            }
        }

        fun dp(i: Int, j: Int, bitLeft: Int, carry: Int): Long {
            if (j < 0 || bitLeft < 0) return 0L
            if (j + carry.countOneBits() < bitLeft) return 0L
            if (j == 0) return if (bitLeft == carry.countOneBits()) 1 else 0
            if (i == n) return 0

            if (cache[i][j][bitLeft][carry] != -1L) return cache[i][j][bitLeft][carry]

            var ret = 0L
            for (count in 0..j) {
                // i번째 원소를 남은 j개 중에서 count개 선택
                val totalCount = carry + count
                
                val restSum = dp(i + 1, j - count, bitLeft - totalCount % 2, totalCount / 2)
                if (restSum != 0L) {
                    val coefficient = comb[j][count] * pows[i][count] % MOD
                    ret = (ret + coefficient * restSum) % MOD
                }
            }

            cache[i][j][bitLeft][carry] = ret
            return ret
        }

        return dp(0, m, k, 0).toInt()
    }

    companion object {
        private const val MOD = 1_000_000_000 + 7L
    }
}