class Solution {
    fun reverseBits(n: Int): Int {
        var answer = 0
        var m = n
        repeat(32) {
            answer = (answer shl 1) or (m and 1)
            m = m shr 1
        }

        return answer 
    }
}