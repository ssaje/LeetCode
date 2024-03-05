class Solution {
    fun bagOfTokensScore(tokens: IntArray, power: Int): Int {
        val sorted = tokens.sorted()
        var i = 0
        var j = tokens.lastIndex

        var rest = power
        var score = 0
        var answer = 0
        while (i <= j) {
            if (sorted[i] <= rest) {
                rest -= sorted[i++]
                ++score
                if (answer < score) {
                    answer = score
                }
            } else if (score > 0) {
                rest += sorted[j--]
                --score
            } else {
                break
            }
        }

        return answer
    }
}