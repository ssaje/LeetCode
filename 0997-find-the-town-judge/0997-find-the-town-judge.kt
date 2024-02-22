class Solution {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        if (n == 1) {
            return if (trust.size == 0) 1 else -1
        }

        val degs = IntArray(n + 1)
        for ((a, b) in trust) {
            degs[a]--
            degs[b]++
        }

        return degs.indexOfFirst { it == n - 1 }
    }
}