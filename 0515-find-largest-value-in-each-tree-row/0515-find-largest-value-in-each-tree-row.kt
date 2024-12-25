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
    fun largestValues(root: TreeNode?): List<Int> {
        if (root == null) {
            return emptyList()
        }

        val answer = mutableListOf<Int>()

        fun dfs(node: TreeNode, level: Int = 0) {
            val value = answer.getOrNull(level)
            if (value == null) {
                answer.add(node.`val`)
            } else {
                answer[level] = answer[level].coerceAtLeast(node.`val`)
            }

            node.left?.let { dfs(it, level + 1) }
            node.right?.let { dfs(it, level + 1) }
        }

        dfs(root)

        return answer
    }
}