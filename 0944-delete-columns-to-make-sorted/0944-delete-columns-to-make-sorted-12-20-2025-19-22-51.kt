class Solution {
    fun minDeletionSize(strs: Array<String>): Int {
        val n = strs.size
        val m = strs[0].length
        val columns = Array(m) { mutableListOf<Char>() }
        for (str in strs) {
            for (j in 0..<m) {
                columns[j] += str[j]
            }
        }

        var answer = 0
        for (column in columns) {
            if (column.joinToString("") != column.sorted().joinToString("")) answer++
        }

        return answer
    }
}