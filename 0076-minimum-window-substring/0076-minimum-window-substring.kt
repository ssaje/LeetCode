class Solution {
    fun minWindow(s: String, t: String): String {
        val counts = IntArray('z'.code + 1)
        var totalCount = 0
        for (ch in t) {
            counts[ch.code]++
            totalCount++
        }

        var minCount = Int.MAX_VALUE
        var answer = 0 to -1
        var start = 0
        for (end in s.indices) {
            val count = --counts[s[end].code]
            if (count >= 0) {
                --totalCount
            }

            while (start < end) {
                val index = s[start].code
                val count = counts[index]
                if (count >= 0) {
                    break
                }

                counts[index]++
                start++
            }

            if (totalCount == 0 && minCount > end - start) {
                minCount = end - start
                answer = start to end
            }
        }

        return s.slice(answer.first..answer.second)
    }
}