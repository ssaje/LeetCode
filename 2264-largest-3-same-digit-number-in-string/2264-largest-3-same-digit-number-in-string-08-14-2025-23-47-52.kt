class Solution {
    fun largestGoodInteger(num: String): String {
        return num
            .windowed(3)
            .filter { it.toSet().size == 1 }
            .maxOrNull()
            ?: ""
    }
}