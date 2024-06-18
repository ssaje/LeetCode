class Solution {
    fun maxProfitAssignment(difficulty: IntArray, profit: IntArray, worker: IntArray): Int {
        val sortedJobs = difficulty.zip(profit).sortedBy { it.second }
        var i = 0
        var max = 0
        var answer = 0
        
        return worker
            .sorted()
            .sumOf {
                while (i < sortedJobs.size && sortedJobs[i].first <= it) {
                    if (max < sortedJobs[i].second) {
                        max = sortedJobs[i].second
                    }

                    i++
                }

                max
            }
    }
}