class Solution {
    fun numberOfAlternatingGroups(colors: IntArray, k: Int): Int {
        var count = 1
        var answer = 0
        for (i in 1..<colors.size+k-1) {
            val j = i % colors.size
            if (colors[j] == colors[(i - 1 + colors.size) % colors.size]) {
                count = 1
                continue
            }

            if (++count >= k) {
                answer++
            }
        }

        return answer
    }
}