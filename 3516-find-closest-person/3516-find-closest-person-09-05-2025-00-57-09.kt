class Solution {
    fun findClosest(x: Int, y: Int, z: Int): Int {
        val diff = (x - z).absoluteValue - (y - z).absoluteValue
        return when {
            diff > 0 -> 2
            diff < 0 -> 1
            else -> 0
        }
    }
}