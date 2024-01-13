class Solution {
    fun minSteps(s: String, t: String): Int {
        val counts = IntArray(26)
        
        for (i in s.indices) {
            counts[s[i] - 'a']++
            counts[t[i] - 'a']--
        }

        return counts
            .asSequence()
            .filter { it > 0 }
            .sumOf { it }
            .absoluteValue
    }
}