class Solution {
    fun maxScoreWords(words: Array<String>, letters: CharArray, score: IntArray): Int {
        var counts = IntArray('z' - 'a' + 1)
        for (letter in letters) {
            counts[letter - 'a']++
        }

        var answer = 0
        var sum = 0
        fun solve(index: Int) {
            if (index == words.size) {
                answer = answer.coerceAtLeast(sum)
                return
            }

            val letterCounts = words[index]
                .groupingBy { it - 'a' }
                .eachCount()
            
            var s = 0
            var isValid = true
            for ((key, value) in letterCounts) {
                if (counts[key] < value) {
                    isValid = false
                    break
                }

                s += value * score[key]
            }

            if (isValid) {
                sum += s
                for ((key, value) in letterCounts) {
                    counts[key] -= value
                }

                solve(index + 1)

                sum -= s
                for ((key, value) in letterCounts) {
                    counts[key] += value
                }

            }

            solve(index + 1)
        }

        solve(0)

        return answer
    }
}