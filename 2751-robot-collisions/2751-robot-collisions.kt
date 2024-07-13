class Solution {
    fun survivedRobotsHealths(positions: IntArray, healths: IntArray, directions: String): List<Int> {
        val sorted = (0..positions.lastIndex).sortedBy { positions[it] }
        val stack = Stack<Pair<Int, Int>>()
        for (i in sorted) {
            var remaining = healths[i]
            while (stack.isNotEmpty() && directions[stack.peek().second] == 'R' && directions[i] == 'L') {
                val prev = stack.peek()
                when {
                    prev.first < remaining -> {
                        stack.pop()
                        remaining--
                    }
                    
                    prev.first > remaining -> {
                        stack.pop()
                        stack.push(prev.first - 1 to prev.second)
                        remaining = 0
                        break
                    }

                    prev.first == remaining -> {
                        stack.pop()
                        remaining = 0
                        break
                    }
                }
            }

            if (remaining > 0) {
                stack.push(remaining to i)
            }
        }

        return stack.toList().sortedBy { it.second }.map { it.first }
    }
}