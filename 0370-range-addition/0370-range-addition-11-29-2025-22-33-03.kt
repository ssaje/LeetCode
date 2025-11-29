class Solution {
    fun getModifiedArray(length: Int, updates: Array<IntArray>): IntArray {
        val answer = IntArray(length)
        for ((s, e, i) in updates) {
            answer[s] += i
            if (e + 1 < length) answer[e + 1] -= i
        }

        var sum = 0
        for (i in 0..<length) {
            sum += answer[i]
            answer[i] = sum
        }

        return answer
    }
}