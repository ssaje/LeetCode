class Solution {
    fun findThePrefixCommonArray(A: IntArray, B: IntArray): IntArray {
        val n = A.size
        val aCounts = IntArray(n)
        val bCounts = IntArray(n)
        
        val answer = IntArray(n)
        for (i in 0..<n) {
            val a = A[i] - 1
            val b = B[i] - 1

            aCounts[a]++
            bCounts[b]++

            if (aCounts[a] == bCounts[a]) {
                answer[i]++
            }

            if (a != b && aCounts[b] == bCounts[b]) {
                answer[i]++
            }

            if (i > 0) {
                answer[i] += answer[i - 1]
            }
        }

        return answer
    }
}