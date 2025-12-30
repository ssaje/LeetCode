class Solution {
    fun dietPlanPerformance(calories: IntArray, k: Int, lower: Int, upper: Int): Int {
        var sum = 0
        for (i in 0..<k-1) {
            sum += calories[i]
        }

        var answer = 0
        for (i in k-1..<calories.size) {
            sum += calories[i]
            if (sum > upper) answer++
            else if (sum < lower) answer--

            sum -= calories[i - k + 1]
        }

        return answer
    }
}