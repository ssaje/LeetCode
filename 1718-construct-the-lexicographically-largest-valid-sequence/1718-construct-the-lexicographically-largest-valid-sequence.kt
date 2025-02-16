class Solution {
    fun constructDistancedSequence(n: Int): IntArray {
        val answer = IntArray(2 * n - 1)
        val checked = BooleanArray(n + 1)
        
        fun backtracking(pos: Int, count: Int): Boolean {
            if (count == n) {
                return true
            }

            if (answer[pos] != 0) {
                return backtracking(pos + 1, count)
            }

            for (i in n downTo 1) {
                if (checked[i]) {
                    continue
                }

                if (i == 1) {
                    checked[i] = true
                    answer[pos] = i

                    if (backtracking(pos + 1, count + 1)) {
                        return true
                    }

                    checked[i] = false
                    answer[pos] = 0

                    continue
                }

                if (pos + i > answer.lastIndex) {
                    break
                }

                if (answer[pos + i] == 0) {
                    checked[i] = true
                    answer[pos] = i
                    answer[pos + i] = i

                    if (backtracking(pos + 1, count + 1)) {
                        return true
                    }

                    checked[i] = false
                    answer[pos] = 0
                    answer[pos + i] = 0
                }
            }

            return false
        }

        backtracking(0, 0)
        
        return answer
    }
}