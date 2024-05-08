class Solution {
    fun findRelativeRanks(score: IntArray): Array<String> {
        val ranksByIndex = score
            .withIndex()
            .sortedByDescending { it.value }
            .mapIndexed { rank, (index, _) -> index to rank }
            .toMap()

        return score
            .mapIndexed { index, _ ->
                when (val rank = ranksByIndex[index]) {
                    0 -> "Gold Medal"
                    1 -> "Silver Medal"
                    2 -> "Bronze Medal"
                    else -> "${rank!! + 1}"
                }
            }
            .toTypedArray()
    }
}