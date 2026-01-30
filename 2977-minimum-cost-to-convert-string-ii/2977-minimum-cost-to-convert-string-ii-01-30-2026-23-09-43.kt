class Solution {
    fun minimumCost(source: String, target: String, original: Array<String>, changed: Array<String>, cost: IntArray): Long {
        Trie.nextId = 0

        val m = original.size
        val dists = Array(m * 2) { i -> IntArray(m * 2) { j -> if (i == j) 0 else MAX } }
        val root = Trie()
        for (k in 0..<m) {
            val i = root.add(original[k])
            val j = root.add(changed[k])
            dists[i][j] = minOf(dists[i][j], cost[k])
        }

        for (k in 0..<Trie.nextId) {
            for (i in 0..<Trie.nextId) {
                for (j in 0..<Trie.nextId) {
                    dists[i][j] = minOf(dists[i][j], dists[i][k] + dists[k][j])
                }
            }
        }

        val n = source.length
        val dp = LongArray(n) { -1 }
        for (i in 0..<n) {
            if (i > 0 && dp[i - 1] == -1L) continue

            val prev = if (i == 0) 0 else dp[i - 1]
            if (source[i] == target[i]) {
                dp[i] = if (dp[i] == -1L) prev else minOf(dp[i], prev)
            }

            var u = root
            var v = root
            for (j in i..<n) {
                u = u.children[source[j] - 'a'] ?: break
                v = v.children[target[j] - 'a'] ?: break

                if (u.id != -1 && v.id != -1 && dists[u.id][v.id] != MAX) {
                    val dist = prev + dists[u.id][v.id]
                    if (dp[j] == -1L || dp[j] > dist) {
                        dp[j] = dist
                    }
                }
            }
        }

        return dp[n - 1]
    }

    private class Trie {
        var id = -1
        val children = arrayOfNulls<Trie>(26)

        fun add(substring: String): Int {
            var node = this
            for (ch in substring) {
                val i = ch - 'a'
                if (node.children[i] == null) {
                    node.children[i] = Trie()
                }

                node = node.children[i]!!
            }

            if (node.id == -1) {
                node.id = nextId++
            }

            return node.id
        }

        companion object {
            var nextId = 0
        }
    }

    companion object {
        private const val MAX = 1000000001
    }
}