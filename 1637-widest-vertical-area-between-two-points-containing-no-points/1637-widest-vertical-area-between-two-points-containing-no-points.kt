class Solution {
    fun maxWidthOfVerticalArea(points: Array<IntArray>): Int {
        return points
            .sortedBy { it[0] }
            .asSequence()
            .zipWithNext()
            .maxOf { it.second[0] - it.first[0] }   
    }
}