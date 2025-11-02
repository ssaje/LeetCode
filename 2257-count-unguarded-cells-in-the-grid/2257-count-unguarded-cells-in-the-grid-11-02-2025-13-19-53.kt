class Solution {
    fun countUnguarded(m: Int, n: Int, guards: Array<IntArray>, walls: Array<IntArray>): Int {
        val ups = BooleanArray(n)
        val downs = BooleanArray(n)

        val gs = guards.map { it[0] to it[1] }.toSet()
        val ws = walls.map { it[0] to it[1] }.toSet()
        val guarded = Array(m) { BooleanArray(n) }
        for (i in 0..<m) {
            var l = false
            for (j in 0..<n) {
                val ij = i to j
                if (ij in ws) {
                    guarded[i][j] = true
                    l = false
                    ups[j] = false
                    continue
                }

                if (ij !in gs) {
                    guarded[i][j] = guarded[i][j] || l || ups[j]
                    continue
                }

                guarded[i][j] = true
                l = true
                ups[j] = true
            }
        }

        for (i in m-1 downTo 0) {
            var r = false
            for (j in n-1 downTo 0) {
                val ij = i to j
                if (ij in ws) {
                    guarded[i][j] = true
                    r = false
                    downs[j] = false
                    continue
                }

                if (ij !in gs) {
                    guarded[i][j] = guarded[i][j] || r || downs[j]
                    continue
                }

                guarded[i][j] = true
                r = true
                downs[j] = true
            }
        }

        var answer = 0
        for (i in 0..<m) {
            for (j in 0..<n) {
                if (!guarded[i][j]) answer++
            }
        }

        return answer
    }
}