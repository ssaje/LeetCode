class Solution {
    fun reverseBits(n: Int): Int {
        var answer = 0
        var m = n
        for (i in 0..<32) {
            answer = (answer shl 1) + (m and 1)
            m = m shr 1
        }

        return answer 
    }
}