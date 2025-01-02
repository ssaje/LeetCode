class Solution {
    fun vowelStrings(words: Array<String>, queries: Array<IntArray>): IntArray {
        val prefixSums = IntArray(words.size)
        
        for (i in words.indices) {
            val word = words[i]
            
            prefixSums[i] = if (word.first() in vowels && word.last() in vowels) {
                1
            } else {
                0
            }

            if (i > 0) {
                prefixSums[i] += prefixSums[i - 1]
            }
        }

        return queries.map { (l, r) -> prefixSums[r] - prefixSums.getOrElse(l - 1) { 0 } }.toIntArray()
    }

    companion object {
        private val vowels = setOf('a', 'e', 'i', 'o', 'u')
    }
}