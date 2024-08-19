class Solution {
    fun minSteps(n: Int): Int {
        val steps = Array(n + 1) { IntArray(n + 1) { 987654321 } }

        steps[1][0] = 0
        steps[1][1] = 1

        for (i in 2..n) {
            var min = Int.MAX_VALUE
            for (j in 1..<i) {
                steps[i][j] = steps[i][j].coerceAtMost(steps[i - j][j] + 1)
                min = min.coerceAtMost(steps[i][j])
            }

            steps[i][i] = min + 1
        }

        return steps[n][n] - 1
    }
}