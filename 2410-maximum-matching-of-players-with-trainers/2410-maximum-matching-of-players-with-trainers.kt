class Solution {
    fun matchPlayersAndTrainers(players: IntArray, trainers: IntArray): Int {
        val sorted = trainers.sortedDescending()
        var answer = 0
        var i = 0
        players.sortedDescending().forEach { player ->
            if (i < sorted.size && player <= sorted[i]) {
                answer++
                i++
            }
        }

        return answer
    }
}