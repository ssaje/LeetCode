class Solution {
    fun pivotInteger(n: Int): Int {
        val sum = n * (n + 1) / 2
        val x = sqrt(sum.toDouble()).toInt()
        return if (x * x == sum) x else -1
    }
}