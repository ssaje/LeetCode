class Solution {
    fun earliestFinishTime(landStartTime: IntArray, landDuration: IntArray, waterStartTime: IntArray, waterDuration: IntArray): Int {
        var answer = Int.MAX_VALUE
        
        var min = Int.MAX_VALUE
        for (i in landStartTime.indices) {
            min = minOf(min, landStartTime[i] + landDuration[i])
        }

        for (i in waterStartTime.indices) {
            answer = minOf(answer, waterDuration[i] + maxOf(waterStartTime[i], min))
        }

        min = Int.MAX_VALUE
        for (i in waterStartTime.indices) {
            min = minOf(min, waterStartTime[i] + waterDuration[i])
        }

        for (i in landStartTime.indices) {
            answer = minOf(answer, landDuration[i] + maxOf(landStartTime[i], min))
        }

        return answer
    }
}