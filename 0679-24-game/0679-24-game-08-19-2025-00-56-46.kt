class Solution {
    fun judgePoint24(cards: IntArray): Boolean {
        val rest = mutableListOf<Double>()
        for (card in cards) {
            rest += card.toDouble()
        }

        fun solve(rest: List<Double>): Boolean {
            if (rest.size == 1) return abs(rest.first() - 24) < 1e-9

            for (i in 0..<rest.size) {
                for (j in i+1..<rest.size) {
                    val results = mutableSetOf(
                        rest[i] + rest[j],
                        rest[i] - rest[j],
                        rest[i] * rest[j],
                        rest[j] - rest[i],
                    )

                    if (rest[i] > 1e-9) results += rest[j] / rest[i]
                    if (rest[j] > 1e-9) results += rest[i] / rest[j]

                    val next = mutableListOf<Double>()
                    for (k in 0..<rest.size) {
                        if (k == i || k == j) continue
                        next += rest[k]
                    }

                    for (result in results) {
                        next += result
                        if (solve(next)) return true
                        next.removeLast()
                    }
                }
            }

            return false
        }

        return solve(rest)
    }
}