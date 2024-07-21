class Solution {
    fun buildMatrix(k: Int, rowConditions: Array<IntArray>, colConditions: Array<IntArray>): Array<IntArray> {
        val rowDegs = IntArray(k)
        val rowGraph = Array(k) { mutableSetOf<Int>() }
        val colDegs = IntArray(k)
        val colSums = IntArray(k)
        val colGraph = Array(k) { mutableSetOf<Int>() }
        val answer = Array(k) { IntArray(k) }

        fun fillDegs(degs: IntArray, conditions: Array<IntArray>, graph: Array<MutableSet<Int>>) {
            for (condition in conditions) {
                val from = condition[0] - 1
                val to = condition[1] - 1
                if (to !in graph[from]) {
                    graph[from].add(to)
                    degs[to]++
                }
            }
        }

        fillDegs(rowDegs, rowConditions, rowGraph)
        fillDegs(colDegs, colConditions, colGraph)

        val queue = ArrayDeque<Int>()

        fun fillQueue(degs: IntArray) {
            for (i in 0..<k) {
                if (degs[i] == 0) {
                    queue.addLast(i)
                }
            }
        }

        fillQueue(colDegs)

        while (queue.isNotEmpty()) {
            val i = queue.removeFirst()
            for (j in colGraph[i]) {
                colSums[j] += colSums[i] + 1
                if (--colDegs[j] == 0) {
                    queue.addLast(j)
                }
            }
        }

        for (i in 0..<k) {
            if (colDegs[i] > 0) {
                return emptyArray()
            }
        }

        queue.clear()
        fillQueue(rowDegs)

        var rowIndex = 0
        while (queue.isNotEmpty()) {
            val i = queue.removeFirst()

            answer[rowIndex++][colSums[i]] = i + 1
            rowDegs[i] = -1
            
            for (j in rowGraph[i]) {
                if (--rowDegs[j] == 0) {
                    queue.addLast(j)
                }
            }
        }

        for (i in 0..<k) {
            if (rowDegs[i] > 0) {
                return emptyArray()
            } else if (rowDegs[i] == 0) {
                answer[rowIndex++][colSums[i]] = i + 1
            }
        }

        return answer
    }
}