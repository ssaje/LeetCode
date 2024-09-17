class Solution {
    fun uncommonFromSentences(s1: String, s2: String): Array<String> {
        val s1Words = s1.split(" ").groupingBy { it }.eachCount().filter { it.value == 1 }.keys.toSet()
        val s2Words = s2.split(" ").groupingBy { it }.eachCount().filter { it.value == 1 }.keys.toSet()

        return (s1Words - s2Words).plus(s2Words - s1Words).toTypedArray()
    }
}