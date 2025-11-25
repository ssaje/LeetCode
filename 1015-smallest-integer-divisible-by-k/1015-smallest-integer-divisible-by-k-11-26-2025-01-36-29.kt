class Solution {
    fun smallestRepunitDivByK(k: Int): Int {
        val remainders = mutableSetOf<Int>()
        var current = 1 % k
        var answer = 1
        while (current !in remainders) {
            remainders += current
            if (current == 0) return answer

            answer++
            current = (current * 10 + 1) % k
        }

        return -1
    }
}