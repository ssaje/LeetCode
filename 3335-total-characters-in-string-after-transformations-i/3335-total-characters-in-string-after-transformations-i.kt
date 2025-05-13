class Solution {
    fun lengthAfterTransformations(s: String, t: Int): Int {
        var current = mutableMapOf<Char, Int>()
        for (ch in s) {
            current[ch] = (current[ch] ?: 0) + 1
        }

        repeat(t) {
            current = buildMap {
                for ((ch, count) in current) {
                    if (ch == 'z') {
                        this['a'] = ((this['a'] ?: 0) + count) % MOD
                        this['b'] = ((this['b'] ?: 0) + count) % MOD
                    } else {
                        this[ch + 1] = ((this[ch + 1] ?: 0) + count) % MOD
                    }
                }
            }.toMutableMap()
        }

        var answer = 0
        for (count in current.values) {
            answer = (answer + count) % MOD
        }

        return answer
    }

    companion object {
        private const val MOD = 1_000_000_000 + 7
    }
}