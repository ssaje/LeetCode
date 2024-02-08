class Solution {
    private val perfectSquares = generateSequence(1 to 1) { it.first + 1 to it.first * it.first }
        .map { it.second }
        .takeWhile { it <= 10_000 }
        .toList()

    private val cache = IntArray(10_000 + 1)

    fun numSquares(n: Int): Int {
        if (n == 0) {
            return 0
        } else if (n == 1) {
            return 1
        } else if (cache[n] != 0) {
            return cache[n]
        }

        var ret = n
        for (perfectSquare in perfectSquares) {
            if (perfectSquare > n) {
                break
            }

            ret = ret.coerceAtMost(numSquares(n - perfectSquare) + 1)
        }

        cache[n] = ret
        return ret
    }
}