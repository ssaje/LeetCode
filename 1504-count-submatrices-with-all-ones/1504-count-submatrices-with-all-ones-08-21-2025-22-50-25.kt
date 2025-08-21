class Solution {
    fun numSubmat(mat: Array<IntArray>): Int {
        val m = mat.size
        val n = mat[0].size
        val current = IntArray(n)
        var answer = 0
        for (row in mat) {
            for (i in 0..<n) {
                if (row[i] == 0) {
                    current[i] = 0
                } else {
                    current[i]++
                }
                
                var height = current[i]
                for (j in i downTo 0) {
                    height = minOf(height, current[j])
                    if (height == 0) break

                    answer += height
                }
            }
        }

        return answer
    }
}