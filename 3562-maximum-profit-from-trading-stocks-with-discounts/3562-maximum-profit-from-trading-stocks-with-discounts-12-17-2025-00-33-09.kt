class Solution {
    fun maxProfit(n: Int, present: IntArray, future: IntArray, hierarchy: Array<IntArray>, budget: Int): Int {
        val childrens = Array(n) { mutableSetOf<Int>() }
        for ((u, v) in hierarchy) {
            childrens[u - 1] += v - 1
        }


        fun dfs(u: Int, b: Int): Answer {
            // 0: non-selected u
            // 1: selected u
            val subDp = Array(b + 1) { IntArray(2) }

            var budgetSum = present[u]
            for (v in childrens[u]) {
                val answer = dfs(v, b)
                budgetSum += answer.budgetSum

                for (i in b downTo 0) {
                    for (subB in 0..minOf(answer.budgetSum, i)) {
                        subDp[i][0] = maxOf(subDp[i][0], subDp[i - subB][0] + answer.dp[subB][0])
                        subDp[i][1] = maxOf(subDp[i][1], subDp[i - subB][1] + answer.dp[subB][1])
                    }
                }
            }

            // 0: non-selected parent
            // 1: selected parent
            val dp = Array(b + 1) { IntArray(2) }

            val price = present[u]
            val discounted = present[u] / 2
            for (i in 0..b) {
                dp[i][0] = subDp[i][0]
                dp[i][1] = subDp[i][0]

                if (i >= price) {
                    dp[i][0] = maxOf(
                        dp[i][0],
                        subDp[i - price][1] + future[u] - price,
                    )
                }

                if (i >= discounted) {
                    dp[i][1] = maxOf(
                        dp[i][1],
                        subDp[i - discounted][1] + future[u] - discounted,
                    )
                }
            }

            return Answer(dp, budgetSum)
        }

        return dfs(0, budget).dp[budget][0]
    }

    private class Answer(
        val dp: Array<IntArray>,
        val budgetSum: Int,
    )
}