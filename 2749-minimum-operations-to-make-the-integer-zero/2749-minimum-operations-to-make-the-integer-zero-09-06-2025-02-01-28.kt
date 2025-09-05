class Solution {
    fun makeTheIntegerZero(num1: Int, num2: Int): Int {
        if (num2 == 0) return num1.countOneBits()

        var answer = 0
        while (true) {
            answer++
            val rest = num1 - answer * num2.toLong()
            if (rest < answer) return -1
            if (answer >= rest.countOneBits()) return answer
        }

        return answer
    }
}