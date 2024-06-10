class Solution {
    fun heightChecker(heights: IntArray): Int {
        val counts = IntArray(101)
        for (height in heights) {
            counts[height]++
        }

        var answer = 0
        var i = 1
        for (height in heights) {
            while (counts[i] == 0) {
                i++
            }

            if (i != height) {
                answer++
            }

            counts[i]--
        }

        return answer
    }
}