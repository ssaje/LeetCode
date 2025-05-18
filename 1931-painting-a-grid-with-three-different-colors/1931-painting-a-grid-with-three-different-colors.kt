class Solution {
    fun colorTheGrid(m: Int, n: Int): Int {
        val upperBound = 3.0.pow(m).toInt()
        val columnsByMask = mutableMapOf<Int, IntArray>()
        for (mask in 0..<upperBound) {
            val column = IntArray(m)
            var rest = mask
            for (i in 0..<m) {
                column[i] = rest % 3
                rest /= 3
            }

            if (isValidColumn(column)) {
                columnsByMask[mask] = column
            }
        }

        var current = mutableMapOf<Int, Int>()
        val transitions = mutableMapOf<Int, MutableList<Int>>()
        for (prev in columnsByMask.keys) {
            current[prev] = 1
            for (next in columnsByMask.keys) {
                if (canTranslate(columnsByMask[prev]!!, columnsByMask[next]!!)) {
                    transitions
                        .getOrPut(prev) { mutableListOf() }
                        .add(next)
                }
            }
        }

        for (i in 1..<n) {
            val masks = mutableMapOf<Int, Int>()
            for (prev in current.keys) {
                for (next in transitions[prev] ?: emptyList()) {
                    masks[next] = ((current[prev] ?: 0) + (masks[next] ?: 0)) % MOD
                }
            }

            current = masks
        }

        var answer = 0
        for (value in current.values) {
            answer = (answer + value) % MOD
        }

        return answer
    }

    fun isValidColumn(column: IntArray): Boolean {
        for (i in 1..<column.size) {
            if (column[i - 1] == column[i]) {
                return false
            }
        }

        return true
    }

    fun canTranslate(prev: IntArray, next: IntArray): Boolean {
        for (i in prev.indices) {
            if (prev[i] == next[i]) {
                return false
            }
        }

        return true
    }

    companion object {
        private const val MOD = 1_000_000_000 + 7
    }
}