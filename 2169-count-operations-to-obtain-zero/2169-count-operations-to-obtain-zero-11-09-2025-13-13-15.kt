class Solution {
    fun countOperations(num1: Int, num2: Int): Int {
        var answer = 0
        var a = num1
        var b = num2
        while (b != 0) {
            answer += a / b
            a = b.also { b = a % b }
        }

        return answer
    }
}