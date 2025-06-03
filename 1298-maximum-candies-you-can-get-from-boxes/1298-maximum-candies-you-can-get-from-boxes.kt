class Solution {
    fun maxCandies(status: IntArray, candies: IntArray, keys: Array<IntArray>, containedBoxes: Array<IntArray>, initialBoxes: IntArray): Int {
        val n = status.size
        val opens = BooleanArray(n)
        val visited = BooleanArray(n)
        val bs = BooleanArray(n)
        val ks = BooleanArray(n)
        val queue = ArrayDeque<Int>()

        for (i in status.indices) opens[i] = status[i] == 1

        for (box in initialBoxes) {
            bs[box] = true
            if (opens[box]) {
                queue.addLast(box)
                visited[box] = true
            }
        }

        var answer = 0
        while (queue.isNotEmpty()) {
            val label = queue.removeFirst()
            answer += candies[label]

            for (key in keys[label]) {
                opens[key] = true
                if (!visited[key] && bs[key]) {
                    queue.addLast(key)
                    visited[key] = true
                }
            }

            for (box in containedBoxes[label]) {
                bs[box] = true
                if (!visited[box] && opens[box]) {
                    queue.addLast(box)
                    visited[box] = true
                }
            }
        }

        return answer
    }
}