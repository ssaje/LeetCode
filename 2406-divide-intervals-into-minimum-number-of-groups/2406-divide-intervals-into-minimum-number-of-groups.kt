class Solution {
    fun minGroups(intervals: Array<IntArray>): Int {
        var answer = 1
        var count = 0

        intervals
            .flatMap {
                listOf(
                    it[0] to 0,
                    it[1] to 1,
                )
            }
            .sortedWith(
                compareBy(
                    { it.first },
                    { it.second },
                )
            )
            .forEach {
                if (it.second == 0) {
                    count++
                    if (answer < count) {
                        answer = count
                    }
                } else {
                    count--
                }
            }

        return answer
    }
}