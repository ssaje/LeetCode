class Solution {
    fun minExtraChar(s: String, dictionary: Array<String>): Int {
        val d = IntArray(s.length)
        for (i in s.indices) {
            d[i] = d.getOrElse(i - 1) { 0 } + 1

            for (word in dictionary) {
                val startIndex = i + 1 - word.length
                if (startIndex < 0) {
                    continue
                }

                if (s.slice(startIndex..i) == word) {
                    d[i] = d[i].coerceAtMost(d.getOrElse(i - word.length) { 0 })
                }
            }
        }

        return d.last()
    }
}