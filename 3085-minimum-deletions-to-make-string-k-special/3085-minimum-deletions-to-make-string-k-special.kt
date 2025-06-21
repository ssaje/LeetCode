class Solution {
    fun minimumDeletions(word: String, k: Int): Int {
        val counts = IntArray(26)
        for (ch in word) {
            counts[ch - 'a']++
        }

        var answer = Int.MAX_VALUE
        for (i in counts.indices) {
            var sum = 0
            for (count in counts) {
                if (count == 0) continue

                if (count < counts[i]) {
                    sum += count
                } else if (count > counts[i] + k) {
                    sum += count - counts[i] - k
                }
            }

            answer = minOf(answer, sum)
        }

        return answer
    }
}