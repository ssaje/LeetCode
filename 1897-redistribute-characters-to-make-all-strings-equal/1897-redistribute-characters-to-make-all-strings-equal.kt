class Solution {
    fun makeEqual(words: Array<String>): Boolean {
        return words
            .asSequence()
            .flatMap { it.asSequence() }
            .groupingBy { it }
            .eachCount()
            .all { (_, count) -> count % words.size == 0 }
    }
}