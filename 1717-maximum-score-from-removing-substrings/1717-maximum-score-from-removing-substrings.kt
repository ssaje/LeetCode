class Solution {
    fun maximumGain(s: String, x: Int, y: Int): Int {
        val sb = StringBuilder(s)
        var score = 0

        fun getScore(target: String, point: Int) {
            var lastIndex = 0
            for (index in 0..<sb.length) {
                sb[lastIndex++] = sb[index]

                if (
                    lastIndex > 1 &&
                    sb[lastIndex - 2] == target[0] &&
                    sb[lastIndex - 1] == target[1]
                ) {
                    lastIndex -= 2
                    score += point
                }
            }
            
            sb.setLength(lastIndex)
        }

        if (x > y) {
            getScore("ab", x)
            getScore("ba", y)  
        } else {
            getScore("ba", y)
            getScore("ab", x)
        }

        return score
    }
}