class Solution {
    companion object {
        private val cache = IntArray(38) { -1 }.apply {
            this[0] = 0
            this[1] = 1
            this[2] = 1
        }
    }

    fun tribonacci(n: Int): Int {
        if(cache[n] != -1) {
            return cache[n]
        }

        cache[n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3)
        return cache[n]
    }
}