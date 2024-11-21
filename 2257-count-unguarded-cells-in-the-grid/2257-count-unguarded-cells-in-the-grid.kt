class Solution {
    fun countUnguarded(m: Int, n: Int, guards: Array<IntArray>, walls: Array<IntArray>): Int {
        val grids = Array(m) { Array(n) { Type.NOT_GUARDED } }
        
        for ((row, col) in guards) {
            grids[row][col] = Type.GUARD
        }

        for ((row, col) in walls) {
            grids[row][col] = Type.WALL
        }

        fun canSee(row: Int, col: Int, isSeen: Boolean): Boolean = when (grids[row][col]) {
            Type.NOT_GUARDED, Type.GUARDED -> isSeen
            Type.GUARD -> true
            Type.WALL -> false
        }

        for (row in 0..<m) {
            var isSeen = canSee(row, 0, false)
            for (col in 1..<n) {
                isSeen = canSee(row, col, isSeen)
                if (isSeen && grids[row][col] == Type.NOT_GUARDED) {
                    grids[row][col] = Type.GUARDED
                }
            }

            isSeen = canSee(row, n-1, false)
            for (col in n-2 downTo 0) {
                isSeen = canSee(row, col, isSeen)
                if (isSeen && grids[row][col] == Type.NOT_GUARDED) {
                    grids[row][col] = Type.GUARDED
                }
            }
        }

        for (col in 0..<n) {
            var isSeen = canSee(0, col, false)
            for (row in 1..<m) {
                isSeen = canSee(row, col, isSeen)
                if (isSeen && grids[row][col] == Type.NOT_GUARDED) {
                    grids[row][col] = Type.GUARDED
                }
            }

            isSeen = canSee(m-1, col, false)
            for (row in m-2 downTo 0) {
                isSeen = canSee(row, col, isSeen)
                if (isSeen && grids[row][col] == Type.NOT_GUARDED) {
                    grids[row][col] = Type.GUARDED
                }
            }
        }

        var answer = 0
        for (row in 0..<m) {
            for (col in 0..<n) {
                if (grids[row][col] == Type.NOT_GUARDED) {
                    answer++
                }
            }
        }

        return answer
    }

    private enum class Type {
        NOT_GUARDED,
        GUARDED,
        GUARD,
        WALL,
    }
}