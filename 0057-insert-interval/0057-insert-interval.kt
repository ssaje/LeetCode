class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val n = intervals.size
        val answer = mutableListOf<IntArray>()
        
        var i = 0
        while (i < n && intervals[i][1] < newInterval[0]) {
            answer += intervals[i++]
        }

        val merged = newInterval.copyOf()
        while (i < n && intervals[i][0] <= merged[1]) {
            merged[0] = min(intervals[i][0], merged[0])
            merged[1] = max(intervals[i][1], merged[1])
            i++
        }
        answer += merged

        while (i < n) {
            answer += intervals[i++]
        }

        return answer.toTypedArray()
    }
}