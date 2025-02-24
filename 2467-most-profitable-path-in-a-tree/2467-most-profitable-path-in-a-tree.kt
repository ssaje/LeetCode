class Solution {
    fun mostProfitablePath(edges: Array<IntArray>, bob: Int, amount: IntArray): Int {
        val n = edges.size + 1
        val graph = Array(n) { mutableSetOf<Int>() }
        for ((a, b) in edges) {
            graph[a] += b
            graph[b] += a
        }

        val bobDistances = IntArray(n) { n }

        fun bobDfs(u: Int, p: Int, distance: Int): Boolean {
            bobDistances[u] = distance

            if (u == 0) {
                return true
            }

            for (v in graph[u]) {
                if (v == p) {
                    continue
                }

                if (bobDfs(v, u, distance + 1)) {
                    return true
                }

                bobDistances[v] = n
            }

            return false
        }

        bobDfs(bob, -1, 0)

        val aliceIncomes = IntArray(n)
        val leafs = mutableListOf<Int>()

        fun aliceDfs(u: Int, p: Int, distance: Int, income: Int) {
            var newIncome = income
            if (distance < bobDistances[u]) {
                newIncome += amount[u]
            } else if (distance == bobDistances[u]) {
                newIncome += amount[u] / 2
            }

            aliceIncomes[u] = newIncome

            var isLeaf = true
            for (v in graph[u]) {
                if (v == p) {
                    continue
                }
            
                isLeaf = false
                aliceDfs(v, u, distance + 1, newIncome)
            }

            if (isLeaf) {
                leafs += u
            }
        }

        aliceDfs(0, -1, 0, 0)

        return leafs.map { aliceIncomes[it] }.max()
    }
}