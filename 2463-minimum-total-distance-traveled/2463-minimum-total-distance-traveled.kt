class Solution {
    fun minimumTotalDistance(robot: List<Int>, factory: Array<IntArray>): Long {
        val sortedRobot = robot.sorted()
        val sortedFactory = factory
            .sortedBy { it[0] }
            .flatMap { (position, limit) -> (1..limit).map { position } }

        val n = sortedFactory.size
        val m = sortedRobot.size
        val dp = Array(n + 1) { LongArray(m + 1) { 200_000_000_000L } }
        dp[0][0] = 0

        var sum = 0
        for (i in 1..n) {
            dp[i][0] = 0

            for (j in 1..m) {
                dp[i][j] = min(
                    (sortedFactory[i - 1] - sortedRobot[j - 1]).absoluteValue + dp[i - 1][j - 1],
                    dp[i - 1][j]
                )
            }
        }

        return dp[n][m]
    }
}