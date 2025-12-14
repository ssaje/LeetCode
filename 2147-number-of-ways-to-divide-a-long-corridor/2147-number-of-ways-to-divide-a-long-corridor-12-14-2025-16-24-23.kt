class Solution {
    fun numberOfWays(corridor: String): Int {
        val n = corridor.length
        var pCount = 0
        var sCount = 0
        var answer = 1L
        var totalS = 0

        for (type in corridor) {
            when (type) {
                'P' -> {
                    if (sCount == 2) pCount++
                }

                else -> {
                    totalS++
                    sCount++
                    if (sCount == 3) {
                        answer = (answer * (pCount + 1)) % MOD
                        sCount = 1
                        pCount = 0
                    }
                }
            }
        }

        return if (totalS == 0 || totalS % 2 == 1) 0 else answer.toInt()
    }

    companion object {
        private const val MOD = 1_000_000_000 + 7
    }
}