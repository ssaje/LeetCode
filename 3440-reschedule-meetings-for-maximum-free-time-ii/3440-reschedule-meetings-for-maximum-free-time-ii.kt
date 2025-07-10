class Solution {
    fun maxFreeTime(eventTime: Int, startTime: IntArray, endTime: IntArray): Int {
        val n = startTime.size
        val maxes = IntArray(n)
        maxes[n - 1] = eventTime - endTime[n - 1]
        for (i in n - 2 downTo 0) {
            maxes[i] = maxOf(startTime[i + 1] - endTime[i], maxes[i + 1])
        }

        var max = 0
        var answer = startTime[0]
        for (i in 0..<n) {
            val lStart = if (i == 0) 0 else endTime[i - 1]
            val rEnd = if (i == n - 1) eventTime else startTime[i + 1]

            answer = maxOf(answer, rEnd - endTime[i])

            val length = endTime[i] - startTime[i]
            if (rEnd - endTime[i] >= length) answer = maxOf(answer, rEnd - endTime[i] - lStart)
            if (i + 1 < n && maxes[i + 1] >= length) answer = maxOf(answer, rEnd - lStart)
            
            if (max >= length) answer = maxOf(answer, rEnd - lStart)
            max = maxOf(max, startTime[i] - lStart)
            if (max >= length) answer = maxOf(answer, rEnd - (lStart + length))
        }

        return answer
    }
}