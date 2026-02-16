class Solution {
    fun reverseBits(n: Int): Int {
        var answer = 0
        var m = n
        for (i in 0..<32) {
            answer = (answer shl 1) or (m and 1)
            m = m ushr 1
        }

        return answer 
    }
}