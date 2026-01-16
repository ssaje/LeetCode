class Solution {
    fun maximizeSquareArea(m: Int, n: Int, hFences: IntArray, vFences: IntArray): Int {
        fun sides(fences: IntArray, maxSide: Int): Set<Int> {
            val sorted = buildList {
                add(1)
                add(maxSide)
                addAll(fences.asIterable())
            }.toMutableList()
            sorted.sort()

            val set = mutableSetOf<Int>()
            for (i in 0..<sorted.size) {
                for (j in i+1..<sorted.size) {
                    set.add(sorted[j] - sorted[i])
                }
            }

            return set
        }

        val hSides = sides(hFences, m)
        val vSides = sides(vFences, n)
        var answer = 0
        for (hSide in hSides) {
            if (hSide in vSides) {
                answer = maxOf(answer, hSide)
            }
        }

        return if (answer == 0) -1 else (answer.toLong() * answer % 1_000_000_007).toInt()
    }
}