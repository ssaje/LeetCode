class Solution {
    fun maxStudents(seats: Array<CharArray>): Int {
        val m = seats.size
        val n = seats[0].size
        
        var total = 0
        
        var uCount = 0
        val uIds = Array(m) { IntArray(n) { -1 } }

        var vCount = 0
        val vIds = Array(m) { IntArray(n) { -1 } }

        for (i in 0..<m) {
            for (j in 0..<n) {
                if (seats[i][j] == '.') {
                    total++

                    if (j % 2 == 0) uIds[i][j] = uCount++
                    else vIds[i][j] = vCount++
                }
            }
        }

        val graph = Array(uCount) { mutableSetOf<Int>() }
        for (i in 0..<m) {
            for (j in 0..<n) {
                if (seats[i][j] == '.' && j % 2 == 0) {
                    val u = uIds[i][j]
                    for ((di, dj) in dirs) {
                        val ni = i + di
                        val nj = j + dj
                        if (ni !in 0..<m || nj !in 0..<n || seats[ni][nj] != '.') continue
                        
                        val v = vIds[ni][nj]
                        graph[u].add(v)
                    }
                }
            }
        }

        val uv = IntArray(uCount) { -1 }
        val vu = IntArray(vCount) { -1 }
        val dists = IntArray(uCount)

        fun bfs(): Boolean {
            val queue = ArrayDeque<Int>()
            for (u in 0..<uCount) {
                if (uv[u] == -1) {
                    dists[u] = 0
                    queue.addLast(u)
                } else {
                    dists[u] = -1
                }
            }

            var isReachable = false
            while (queue.isNotEmpty()) {
                val u = queue.removeFirst()
                for (v in graph[u]) {
                    val w = vu[v]
                    if (w != -1) {
                        if (dists[w] == -1) {
                            dists[w] = dists[u] + 1
                            queue.addLast(w)
                        }
                    } else {
                        isReachable = true
                    }
                }
            }

            return isReachable
        }

        fun dfs(u: Int): Boolean {
            for (v in graph[u]) {
                val w = vu[v]
                if (w == -1 || (dists[w] == dists[u] + 1 && dfs(w))) {
                    uv[u] = v
                    vu[v] = u
                    return true
                }
            }

            dists[u] = -1
            return false
        }

        var maxMatching = 0
        while (bfs()) {
            for (u in 0..<uCount) {
                if (uv[u] == -1 && dfs(u)) maxMatching++
            }
        }

        return total - maxMatching
    }

    companion object {
        private val dirs = listOf(
            -1 to -1, -1 to 1,
            0 to -1, 0 to 1,
            1 to -1, 1 to 1,
        )
    }
}