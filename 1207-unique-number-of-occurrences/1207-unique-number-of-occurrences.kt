class Solution {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        return arr
            .asSequence()
            .groupingBy { it }
            .eachCount()
            .let { it.size == it.values.toSet().size }
    }
}