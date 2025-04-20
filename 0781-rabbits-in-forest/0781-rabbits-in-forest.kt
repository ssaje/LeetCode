class Solution {
    fun numRabbits(answers: IntArray): Int {
        val counts = mutableMapOf<Int, Int>()
        for (answer in answers) {
            counts[answer] = (counts[answer] ?: 0) + 1
        }

        // 3 -> 3 + 0
        // 4 -> 4 + 2
        // 5 -> 5 + 1

        return counts.entries.sumOf { (key, value) -> (value + key) / (key + 1) * (key + 1) }
    }
}