class Solution {
    fun minWindow(s: String, t: String): String {
        val counts = IntArray('z'.code + 1)
        val m = t.length
        var totalCount = 0
        for (ch in t) {
            counts[ch.code]++
        }

        var minCount = Int.MAX_VALUE
        var answer = 0 to -1
        var start = 0
        for (end in s.indices) {
            val count = --counts[s[end].code]
            if (count >= 0) {
                totalCount++
            }

            while (totalCount == m) {
                if (minCount > end - start) {
                    minCount = end - start
                    answer = start to end
                }

                val count = ++counts[s[start].code]
                if (count > 0) {
                    --totalCount
                }
                
                ++start
            }
        }

        return s.slice(answer.first..answer.second)
    }
}