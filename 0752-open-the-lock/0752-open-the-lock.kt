class Solution {
    fun openLock(deadends: Array<String>, target: String): Int {
        val visited = HashSet<Int>()
        val queue = ArrayDeque<Pair<Int, Int>>().apply {
            this.addLast(0 to 0)
            visited.add(0)
        }

        val targetInt = target.toInt()
        val deadendSet = deadends
            .map { it.toInt() }
            .toSet()

        while (queue.isNotEmpty()) {
            val (dist, node) = queue.removeFirst()
            if (node == targetInt) {
                return dist
            }

            if (node in deadendSet) {
                continue
            }

            var weight = 1
            for (i in 0..3) {
                val digit = node.toString().padStart(4, '0')[3 - i].digitToInt()
                val number = node - (digit * weight)
                val up = number + ((digit + 1) % 10 * weight)
                val down = number + ((digit + 9) % 10 * weight)
                
                if (up !in visited) {
                    queue.addLast(dist + 1 to up)
                    visited.add(up)
                }

                if (down !in visited) {
                    queue.addLast(dist + 1 to down)
                    visited.add(down)
                }

                weight *= 10
            }
        }

        return -1
    }
}