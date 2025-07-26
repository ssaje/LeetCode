class Solution {
    fun maxSubarrays(n: Int, conflictingPairs: Array<IntArray>): Long {
        val bMins = Array(n + 1) { intArrayOf(n + 1, n + 1) }
        for (pair in conflictingPairs) {
            val a = minOf(pair[0], pair[1])
            val b = maxOf(pair[0], pair[1])
            if (bMins[a][0] > b) {
                bMins[a][1] = bMins[a][0]
                bMins[a][0] = b
            } else if (bMins[a][1] > b) {
                bMins[a][1] = b
            }
        }

        var sum = 0L
        var minIndex = n
        var secondMin = n + 1
        val counts = LongArray(n + 1)
        for (i in n downTo 1) {
            if (bMins[minIndex][0] > bMins[i][0]) {
                secondMin = minOf(secondMin, bMins[minIndex][0])
                minIndex = i
            } else if (secondMin > bMins[i][0]) {
                secondMin = bMins[i][0]
            }

            sum += bMins[minIndex][0] - i
            counts[minIndex] += minOf(secondMin, bMins[minIndex][1]) - bMins[minIndex][0]
        }

        return sum + counts.max()
    }
}