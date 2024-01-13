class Solution {
    fun minSteps(s: String, t: String): Int {
        val counts = IntArray('z'.toInt())
        
        for (i in s.indices) {
            counts[s[i].toInt() - 97]++
            counts[t[i].toInt() - 97]--
        }

        return counts
            .asSequence()
            .filter { it > 0 }
            .sumOf { it }
            .absoluteValue
    }
}