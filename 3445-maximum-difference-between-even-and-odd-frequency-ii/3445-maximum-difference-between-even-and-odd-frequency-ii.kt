class Solution {
    fun maxDifference(s: String, k: Int): Int {
        // max(odd - even) every subs, 0 ~ 4
        var answer = -s.length
        for (a in '0'..'4') {
            for (b in '0'..'4') {
                if (a == b) continue

                var left = -1
                var currentA = 0
                var currentB = 0
                var prevA = 0
                var prevB = 0
                val counts = IntArray(4) { s.length }
                for (right in s.indices) {
                    if (s[right] == a) currentA++
                    else if (s[right] == b) currentB++

                    while (right - left >= k && currentB - prevB >= 2) {
                        val index = state(prevA, prevB)
                        counts[index] = minOf(counts[index], prevA - prevB)
                        left++
                        if(s[left] == a) prevA++
                        else if (s[left] == b) prevB++
                    }

                    val index = state(currentA, currentB) xor 0b10
                    if (counts[index] != s.length) {
                        answer = maxOf(answer, currentA - currentB - counts[index])
                    }
                }
            }
        }

        return answer
    }

    private fun state(a: Int, b: Int): Int = (a % 2) * 2 + b % 2
}