class Solution {
    fun findChampion(n: Int, edges: Array<IntArray>): Int {
        val degs = IntArray(n)
        for ((_, b) in edges) {
            degs[b]++
        }

        var count = 0
        var answer = -1
        for (i in 0..<n) {
            if (degs[i] == 0) {
                count++
                answer = i
            }
        }

        return answer.takeIf { count == 1 } ?: -1
    }
}