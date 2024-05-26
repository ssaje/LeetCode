class Solution {
    companion object {
        private const val MOD = 1_000_000_000 + 7
    }

    fun checkRecord(n: Int): Int {
        when (n) {
            1 -> return 3
            2 -> return 8
        }

        val d = Array(n + 1) { IntArray(2) }

        d[0][0] = 1

        d[1][0] = 2
        d[1][1] = 1

        d[2][0] = 4
        d[2][1] = 4
        
        for (i in 3..n) {
            d[i][0] = d[i - 1][0] sumMod d[i - 2][0] sumMod d[i - 3][0]
            d[i][1] = d[i - 1][1] sumMod d[i - 2][1] sumMod d[i - 3][1] sumMod d[i][0]
        }

        return d[n][0] sumMod d[n][1]
    }

    private infix fun Int.sumMod(other: Int): Int {
        return (this + other) % MOD
    }
}