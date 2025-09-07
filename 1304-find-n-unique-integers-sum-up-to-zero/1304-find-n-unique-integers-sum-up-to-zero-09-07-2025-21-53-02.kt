class Solution {
    fun sumZero(n: Int): IntArray {
        val answer = IntArray(n)
        for (i in 1..<n step 2) {
            answer[i] = 1 + i / 2
            answer[i - 1] = -answer[i]
        }

        return answer
    }
}