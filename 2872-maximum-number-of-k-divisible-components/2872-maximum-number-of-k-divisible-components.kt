class Solution {
    fun maxKDivisibleComponents(n: Int, edges: Array<IntArray>, values: IntArray, k: Int): Int {
        var answer = 0
        val tree = Array(n) { mutableSetOf<Int>() }

        for ((a, b) in edges) {
            tree[a].add(b)
            tree[b].add(a)
        }
        
        fun dfs(u: Int, p: Int = -1): Int {
            var sum = values[u] % k
            for (v in tree[u]) {
                if (v == p) {
                    continue
                }

                sum = (sum + dfs(v, u)) % k
            }

            if (sum == 0) {
                answer++
            }
            
            return sum
        }

        dfs(0)

        return answer
    }
}