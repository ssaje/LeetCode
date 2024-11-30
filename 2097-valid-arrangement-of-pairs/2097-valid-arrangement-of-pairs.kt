class Solution {
    fun validArrangement(pairs: Array<IntArray>): Array<IntArray> {
        if (pairs.size == 1) {
            return pairs
        }

        val indegs = mutableMapOf<Int, Int>()
        val outdegs = mutableMapOf<Int, Int>()
        val graph = mutableMapOf<Int, MutableList<Int>>()
        for ((start, end) in pairs) {
            if (start !in graph) {
                graph[start] = mutableListOf()
            }

            graph[start]?.add(end)

            outdegs[start] = (outdegs[start] ?: 0) + 1
            indegs[end] = (indegs[end] ?: 0) + 1
        }

        var start = indegs.keys.first()
        for (u in indegs.keys union outdegs.keys) {
            if ((indegs[u] ?: 0) + 1 == (outdegs[u] ?: 0)) {
                start = u
                break
            }
        }

        val stack = Stack<Int>()
        val path = mutableListOf<Int>()

        stack.push(start)
        while (stack.isNotEmpty()) {
            val u = stack.peek()
            if ((graph[u]?.size ?: 0) == 0) {
                path += u
                stack.pop()
            } else {
                val v = graph[u]!!.last()
                graph[u]!!.removeLast()
                stack.push(v)
            }
        }

        val answer = Array(path.size - 1) { IntArray(2) }
        for (i in path.lastIndex downTo 1) {
            val j = path.lastIndex - i
            answer[j][0] = path[i]
            answer[j][1] = path[i - 1]
        }

        return answer
    }
}