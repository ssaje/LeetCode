class Solution {
    fun robotSim(commands: IntArray, obstacles: Array<IntArray>): Int {
        val blockers = obstacles.map { it[0] to it[1] }.toSet()
        var x = 0
        var y = 0
        var dx = 0
        var dy = 1

        var answer = 0
        for (command in commands) {
            if (command == -2) {
                dx = -dy.also { dy = dx }
            } else if (command == -1) {
                dx = dy.also { dy = -dx }
            } else {
                for (move in 0..<command) {
                    val nx = x + dx
                    val ny = y + dy
                    if (nx to ny in blockers) {
                        break
                    }

                    x = nx
                    y = ny
                    answer = answer.coerceAtLeast(x * x + y * y)
                }
            }
        }

        return answer
    }
}