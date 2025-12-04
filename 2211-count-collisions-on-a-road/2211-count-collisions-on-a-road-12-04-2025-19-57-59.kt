class Solution {
    fun countCollisions(directions: String): Int {
        var answer = 0
        var count = 0
        for (direction in directions) {
            when (direction) {
                'R' -> count++
                'L', 'S' -> {
                    answer += count
                    count = 0
                }
            }
        }

        count = 0
        for (i in directions.length - 1 downTo 0) {
            when (directions[i]) {
                'L' -> count++
                'R', 'S' -> {
                    answer += count
                    count = 0
                }
            }
        }

        return answer
    }
}