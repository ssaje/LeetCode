class Solution {
    fun maxFreeTime(eventTime: Int, k: Int, startTime: IntArray, endTime: IntArray): Int {
        val n = startTime.size
        val freeTimes = IntArray(n + 1)
        freeTimes[0] = startTime[0]
        freeTimes[n] = eventTime - endTime[n - 1]
        for (i in 1..<n) {
            freeTimes[i] = startTime[i] - endTime[i - 1]
        }

        var answer = 0
        var sum = 0        
        for (i in 0..n) {
            sum += freeTimes[i]
            if (i >= k) {
                answer = maxOf(answer, sum)
                sum -= freeTimes[i - k]
            }
        }

        return answer
    }
}