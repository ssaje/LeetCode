/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun minimumOperations(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        val queue = ArrayDeque<TreeNode>()
        queue.addLast(root)

        var answer = 0

        while (queue.isNotEmpty()) {
            val nodes = mutableListOf<Int>()
            repeat(queue.size) {
                val node = queue.removeFirst()
                nodes += node.`val`

                node.left?.let { queue.addLast(it) }
                node.right?.let { queue.addLast(it) }
            }

            val sorted = nodes.sorted()
            val indexes = nodes.withIndex().associate { it.value to it.index }.toMutableMap()
            for (i in nodes.indices) {
                val node = nodes[i]
                if (node == sorted[i]) {
                    continue
                }

                answer++
                val j = indexes[sorted[i]]!!
                nodes[j] = node
                indexes[node] = j
            }
        }

        return answer
    }
}