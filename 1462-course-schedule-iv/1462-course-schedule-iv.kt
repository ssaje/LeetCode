class Solution {
    fun checkIfPrerequisite(numCourses: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): List<Boolean> {
        val canReach = Array(numCourses) { BooleanArray(numCourses) }
        for (i in 0..<numCourses) {
            canReach[i][i] = true
        }

        for ((a, b) in prerequisites) {
            canReach[a][b] = true
        }

        for (k in 0..<numCourses) {
            for (i in 0..<numCourses) {
                if (!canReach[i][k]) {
                    continue
                }

                for (j in 0..<numCourses) {
                    if (canReach[k][j]) {
                        canReach[i][j] = true
                    }   
                }
            }   
        }

        return queries.map { (u, v) -> canReach[u][v] }
    }
}