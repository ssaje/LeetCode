class Solution {
    fun checkValidCuts(n: Int, rectangles: Array<IntArray>): Boolean {
        fun canCut(sorted: List<IntArray>, start: (rectangle: IntArray) -> Int, end: (rectangle: IntArray) -> Int): Boolean {
            var sectionCount = 0
            var e = end(sorted[0])
            for (rectangle in sorted) {
                val rs = start(rectangle)
                if (e <= rs) {
                    sectionCount++
                    if (sectionCount == 2) {
                        return true
                    }
                }

                e = maxOf(e, end(rectangle))
            }

            return false
        }

        return canCut(
            rectangles.sortedBy { it[0] },
            { it[0] },
            { it[2] },
        ) || canCut(
            rectangles.sortedBy { it[1] },
            { it[1] },
            { it[3] },
        )
    }
}