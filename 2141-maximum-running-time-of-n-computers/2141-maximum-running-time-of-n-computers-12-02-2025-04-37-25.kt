class Solution {
    fun maxRunTime(n: Int, batteries: IntArray): Long {
        val sorted = batteries.sorted()
        
        var sum = 0L
        for (battery in batteries) sum += battery

        var m = n
        for (i in sorted.size - 1 downTo 0) {
            if (sorted[i] <= sum / m) return sum / m

            m--
            sum -= sorted[i]
        }

        return 0L
    }
}