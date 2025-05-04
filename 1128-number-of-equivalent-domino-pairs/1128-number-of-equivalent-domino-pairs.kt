class Solution {
    fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {
        val counts = mutableMapOf<String, Int>()
        for (domino in dominoes) {
            val a = min(domino[0], domino[1])
            val b = max(domino[0], domino[1])
            counts["$a$b"] = (counts["$a$b"] ?: 0) + 1
        }

        return counts.values.sumOf { (it - 1) * it / 2 }
    }
}