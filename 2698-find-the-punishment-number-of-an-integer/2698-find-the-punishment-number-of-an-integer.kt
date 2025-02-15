class Solution {
    fun punishmentNumber(n: Int): Int {
        var answer = 0

        fun backtracking(i: Int, m: String, index: Int, sum: Int, partitioned: Int): Boolean {
            val acc = sum + partitioned
            if (acc > n) {
                return false
            } else if (index == m.length) {
                return sum + partitioned == i
            }

            val digit = m[index].digitToInt()
            return backtracking(i, m, index + 1, sum, partitioned * 10 + digit) ||
                backtracking(i, m, index + 1, sum + partitioned, digit)
        }

        for (i in 1..n) {
            val m = i*i
            if (backtracking(i, m.toString(), 0, 0, 0)) {
                answer += m
            }
        }

        return answer
    }
}