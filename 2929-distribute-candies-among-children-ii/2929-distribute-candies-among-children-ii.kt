class Solution {
    fun distributeCandies(n: Int, limit: Int): Long {
        var answer = 0L
        for (i in 0..minOf(n, limit)) {
            answer += maxOf(minOf(n - i, limit) - maxOf(n - i - limit, 0) + 1, 0)
        }

        return answer
    }
}