class Solution {
    fun binaryGap(n: Int): Int {
        val binary = n.toString(2)
        var prev = -1
        var current = -1
        var answer = 0
        for (i in 0..<binary.length) {
            if (binary[i] == '1') {
                prev = current
                current = i

                if (prev != -1) answer = maxOf(answer, current - prev)
            }
        }

        return answer
    }
}