class Solution {
    fun pivotInteger(n: Int): Int {
        val x = sqrt((n * (n + 1) / 2).toDouble())
        val floored = x.toInt()
        return if (ceil(x).toInt() == floored) floored else -1
    }
}