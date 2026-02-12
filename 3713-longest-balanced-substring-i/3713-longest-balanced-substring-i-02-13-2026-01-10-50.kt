class Solution {
    fun longestBalanced(s: String): Int {
        fun count(counts: IntArray): Int {
            var currentCount = counts.max()
            var sum = 0
            for (i in 0..<26) {
                if (counts[i] > 0 && currentCount != counts[i]) {
                    return 0
                }

                sum += counts[i]
            }

            return sum
        }

        val n = s.length
        var answer = 0
        for (i in 0..<n) {
            val counts = IntArray(26)
            for (j in i..<n) {
                counts[s[j] - 'a']++
                answer = maxOf(answer, count(counts))
            }
        }

        return answer
    }
}