class Solution {
    fun smallestNumber(n: Int): Int {
        var m = n
        m = m or (m shr 1)
        m = m or (m shr 2)
        m = m or (m shr 4)
        m = m or (m shr 8)
        return m
    }
}