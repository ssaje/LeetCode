class Solution {
    fun minOperations(queries: Array<IntArray>): Long {
        var answer = 0L
        for ((l, r) in queries) {
            answer += (sum(r) - sum(l - 1) + 1) / 2
        }

        return answer
    }

    private fun sum(num: Int): Long {
        var ret = 0L
        var l = 1L
        var count = 1
        val limit = num.toLong()
        do {
            val r = minOf(l * 4 - 1, limit)
            ret += count * (r - l + 1)
            count++
            l *= 4
        } while (r != limit)

        return ret
    }
}