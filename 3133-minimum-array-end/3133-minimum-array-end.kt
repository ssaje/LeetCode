class Solution {
    fun minEnd(n: Int, x: Int): Long {
        var answer = x.toLong()
        var m = n - 1
        var weight = 1L
        while (m > 0) {
            if (answer and weight == 0L) {
                if (m and 1 > 0) {
                    answer = answer or weight
                }

                m = m shr 1
            }

            weight = weight shl 1
        }

        return answer
    }
}