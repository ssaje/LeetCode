class Solution {
    fun wonderfulSubstrings(word: String): Long {
        val frequeciesByXored = mutableMapOf(0 to 1)
        var prefix = 0
        var answer = 0L

        for (ch in word) {
            prefix = prefix xor (1 shl (ch - 'a'))
            
            val frequency = frequeciesByXored[prefix] ?: 0
            answer += frequency
            frequeciesByXored[prefix] = frequency + 1

            var w = 1
            repeat(10) {
                answer += frequeciesByXored[prefix xor w] ?: 0
                w = w shl 1
            }
        }

        return answer
    }
}