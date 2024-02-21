class Solution {
    fun rangeBitwiseAnd(left: Int, right: Int): Int {
        var answer = 0
        var pos = 1 shl 30
        while (pos > 0) {
            if (left and pos == right and pos) {
                answer = answer or (left and pos)
                pos = pos shr 1
            } else {
                break
            }
        }

        return answer
    }
}