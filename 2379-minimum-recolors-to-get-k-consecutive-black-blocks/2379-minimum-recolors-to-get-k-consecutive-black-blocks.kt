class Solution {
    fun minimumRecolors(blocks: String, k: Int): Int {
        var answer = blocks.length
        var white = 0
        for (i in blocks.indices) {
            if (blocks[i] == 'W') {
                white++
            }

            if (i >= k && blocks[i - k] == 'W') {
                white--
            }

            if (i + 1 >= k) {
                answer = minOf(answer, white)
            }
        }

        return answer
    }
}