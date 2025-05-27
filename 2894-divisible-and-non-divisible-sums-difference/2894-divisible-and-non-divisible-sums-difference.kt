class Solution {
    fun differenceOfSums(n: Int, m: Int): Int {
        var num1 = 0
        var num2 = 0
        for (num in 1..n) {
            if (num % m == 0) num2 += num
            else num1 += num
        }

        return num1 - num2
    }
}