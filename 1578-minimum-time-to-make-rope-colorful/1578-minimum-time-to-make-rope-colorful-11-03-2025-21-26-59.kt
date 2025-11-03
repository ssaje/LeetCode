class Solution {
    fun minCost(colors: String, neededTime: IntArray): Int {
        val n = colors.length
        var currentColor = ' '
        var sum = 0
        var max = 0

        var answer = 0
        for ((index, color) in colors.withIndex()) {
            if (currentColor == color) {
                sum += neededTime[index]
                max = maxOf(max, neededTime[index])
                continue
            }

            currentColor = color
            answer += sum - max
            sum = neededTime[index]
            max = neededTime[index]
        }

        return answer + sum - max
    }
}