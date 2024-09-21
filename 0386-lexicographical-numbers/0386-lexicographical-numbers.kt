class Solution {
    fun lexicalOrder(n: Int): List<Int> {
        val answer = mutableListOf<Int>()
        
        var current = 1
        repeat(n) {
            answer += current

            if (current * 10 <= n) {
                current *= 10
            } else {
                while (current % 10 == 9 || current == n) {
                    current /= 10
                }

                current++
            }
        }

        return answer
    }
}