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
    fun lcaDeepestLeaves(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }

        val pq = PriorityQueue<Triple<Int, TreeNode, TreeNode?>> { a, b -> b.first - a.first } // depth, node, parent
        var maxDepth = 0
        var count = 0
        fun dfs(node: TreeNode, parent: TreeNode?, depth: Int) {
            if (maxDepth < depth) {
                maxDepth = depth
                count = 1
            } else if (maxDepth == depth) {
                count++
            }

            pq.offer(Triple(depth, node, parent))
            node.left?.let { dfs(it, node, depth + 1) }
            node.right?.let { dfs(it, node, depth + 1) }
        }

        dfs(root, null, 0)

        val sums = mutableMapOf<Int, Int>()
        while (pq.isNotEmpty()) {
            val (depth, node, parent) = pq.poll()
            var sum = sums[node.`val`] ?: 0
            if (maxDepth == depth) {
                sum++
            }

            if (sum == count) {
                return node
            }

            if (parent != null) {
                sums[parent.`val`] = (sums[parent.`val`] ?: 0) + sum
            }
        }

        return null
    }
}