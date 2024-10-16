class Solution {
    fun longestDiverseString(a: Int, b: Int, c: Int): String {
        // A <= B <= C
        val sorted = listOf(
            'a' to a,
            'b' to b,
            'c' to c,
        ).sortedBy { it.second }
        val counts = IntArray(3) { sorted[it].second }
        val (s, m, l) = sorted.map { it.first }

        val answer = StringBuilder()
        while (counts[2] > 0) {
            if (counts[0] == 0) {
                if (counts[1] == 0) {
                    answer.append("$l".repeat(counts[2].coerceAtMost(2)))
                    break
                }

                if (counts[1] + 1 < counts[2]) {
                    answer.append("$l$l$m")
                    counts[1]--
                    counts[2] -= 2
                }

                if (counts[1] + 1 == counts[2]) {
                    answer.append(l)
                    counts[2]--
                }

                if (counts[1] == counts[2]) {
                    answer.append("$m$l".repeat(counts[1]))
                    break
                }
            } else if (counts[0] == counts[1]) {
                // A = B = C
                if (counts[1] == counts[2]) {
                    answer.append("$l$m$s".repeat(counts[2]))
                    break
                }

                // A = B < C
                if (counts[1] + 1 < counts[2]) {
                    answer.append("$l$l$s")
                    counts[0]--
                    counts[2] -= 2
                    continue
                }
                
                if (counts[1] + 1 == counts[2]) {
                    answer.append(l)
                    counts[2]--
                }

                if (counts[1] == counts[2]) {
                    answer.append("$m$l$s".repeat(counts[2]))
                    break
                }
            } else {
                // A < B = C
                if (counts[1] == counts[2]) {
                    answer.append("$l$m")
                    counts[1]--
                    counts[2]--
                    continue
                }

                // A < B < C
                if (counts[1] + 1 < counts[2]) {
                    answer.append("$l$l$m")
                    counts[1]--
                    counts[2] -= 2
                } else if (counts[1] + 1 == counts[2]) {
                    answer.append("$l$m")
                    counts[1]--
                    counts[2]--
                }
            }
        }

        return answer.toString()
    }
}