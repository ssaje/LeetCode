class Solution {
    fun findWinners(matches: Array<IntArray>): List<List<Int>> {
        val indeg = HashMap<Int, Int>()
        for ((winner, loser) in matches) {
            indeg[winner] = indeg[winner] ?: 0
            indeg[loser] = (indeg[loser] ?: 0) + 1
        }

        return listOf(
            indeg.filter { it.value == 0 }.keys.sorted(),
            indeg.filter { it.value == 1 }.keys.sorted(),
        )
    }
}