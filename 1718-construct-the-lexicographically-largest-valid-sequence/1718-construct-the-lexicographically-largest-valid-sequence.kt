class Solution {
    fun constructDistancedSequence(n: Int): IntArray {
        val answer = IntArray(2 * n - 1)
        val checked = BooleanArray(n + 1)
        
        fun backtracking(pos: Int, target: Int): Boolean {
            if (pos == answer.size) {
                return true
            }

            if (answer[pos] != 0) {
                return backtracking(pos + 1, target)
            }

            for (i in target downTo 1) {
                if (checked[i]) {
                    continue
                }

                if (i == 1) {
                    checked[i] = true
                    answer[pos] = i

                    if (backtracking(pos + 1, target)) {
                        return true
                    }

                    checked[i] = false
                    answer[pos] = 0
                } else if (pos + i < answer.size && answer[pos + i] == 0) {
                    checked[i] = true
                    answer[pos] = i
                    answer[pos + i] = i

                    if (backtracking(pos + 1, target)) {
                        return true
                    }

                    checked[i] = false
                    answer[pos] = 0
                    answer[pos + i] = 0
                }
            }

            return false
        }

        backtracking(0, n)
        
        return answer
    }
}