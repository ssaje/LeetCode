class Solution {
    fun maxDistance(s: String, k: Int): Int {
        var answer = 0
        var x = 0
        var y = 0
        for (i in s.indices) {
            when (s[i]) {
                'N' -> y++
                'S' -> y--
                'E' -> x++
                else -> x--
            }

            answer = maxOf(answer, minOf(x.absoluteValue + y.absoluteValue + 2 * k, i + 1))
        }

        return answer
    }
}