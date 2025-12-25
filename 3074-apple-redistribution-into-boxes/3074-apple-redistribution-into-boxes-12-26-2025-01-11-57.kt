class Solution {
    fun minimumBoxes(apple: IntArray, capacity: IntArray): Int {
        var sum = apple.sum()
        var answer = 0
        val sorted = capacity.sorted()
        for (i in sorted.size - 1 downTo 0) {
            if (sum > 0) {
                sum -= minOf(sum, capacity[i])
                answer++
            } else if (sum == 0) {
                break
            }
        }

        return answer
    }
}