class Solution {
    fun findRotateSteps(ring: String, key: String): Int {
        val n = key.length
        val queue = ArrayDeque<Triple<Int, Int, Int>>() // dist keyIndex ringIndex
        queue.addLast(Triple(0, 0, 0))

        val m = ring.length
        val visited = Array(n) { BooleanArray(m) }
        visited[0][0] = true

        while (queue.isNotEmpty()) {
            val (d, k, r) = queue.removeFirst()
            if (key[k] == ring[r]) {
                if (k + 1 == n) {
                    return d + 1
                }

                if (!visited[k + 1][r]) {
                    queue.addLast(Triple(d + 1, k + 1, r))
                    visited[k + 1][r] = true
                }

                continue
            }

            val prev = (r + m - 1) % m
            if (!visited[k][prev]) {
                queue.addLast(Triple(d + 1, k, prev))
                visited[k][prev] = true
            }

            val next = (r + 1) % m
            if (!visited[k][next]) {
                queue.addLast(Triple(d + 1, k, next))
                visited[k][next] = true
            }
        }

        return 0
    }
}