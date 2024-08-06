class Solution {
    fun minimumPushes(word: String): Int {
        val freqs = word
            .groupingBy { it }
            .eachCount()
            .toList()
            .sortedByDescending { it.second }
            .mapIndexed { index, entry -> entry.first to index }
            .toMap()
        
        return word.sumOf { freqs.getValue(it) / 8 + 1 }
    }
}