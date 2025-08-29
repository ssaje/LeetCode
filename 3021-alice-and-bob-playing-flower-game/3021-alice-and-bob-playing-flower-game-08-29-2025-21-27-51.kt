class Solution {
    fun flowerGame(n: Int, m: Int): Long {
        return (n + 1L) / 2 * (m / 2) + (m + 1L) / 2 * (n / 2L)
    }
}