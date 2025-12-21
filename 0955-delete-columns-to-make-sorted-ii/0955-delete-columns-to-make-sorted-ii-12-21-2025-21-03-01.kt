class Solution {
    fun minDeletionSize(strs: Array<String>): Int {
        val m = strs[0].length
        val n = strs.size
        val isFixed = BooleanArray(n)

        fun isLexicographic(col: Int): Boolean {
            var prev = 'a'
            val fixed = isFixed.copyOf()
            for (row in 0..<n) {
                if (!fixed[row]) {
                    if (prev > strs[row][col]) return false
                    else if (prev < strs[row][col]) fixed[row] = true
                }
                
                prev = strs[row][col]
            }

            for (row in 0..<n) {
                isFixed[row] = fixed[row]
            }

            return true
        }

        var answer = 0
        for (col in 0..<m) {
            if (!isLexicographic(col)) answer++
        }

        return answer
    }
}