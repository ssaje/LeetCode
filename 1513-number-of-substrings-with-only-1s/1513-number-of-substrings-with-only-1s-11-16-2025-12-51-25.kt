class Solution {
    fun numSub(s: String): Int {
        var count = 0
        var answer = 0
        for (ch in s) {
            if (ch == '1') {
                count++
                answer = (answer + count) % MOD
            } else {
                count = 0
            }
        }

        return answer
    }

    companion object {
        private const val MOD = 1_000_000_000 + 7
    }
}