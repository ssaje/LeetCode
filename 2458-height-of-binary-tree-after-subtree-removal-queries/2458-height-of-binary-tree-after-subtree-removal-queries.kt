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
    fun treeQueries(root: TreeNode?, queries: IntArray): IntArray {
        val heights = IntArray(100_000 + 1)

        var maxHeight = 0
        fun dfs(node: TreeNode?, height: Int, isLeftToRight: Boolean = true) {
            if (node == null) {
                return
            }

            heights[node.`val`] = heights[node.`val`].coerceAtLeast(maxHeight)
            maxHeight = maxHeight.coerceAtLeast(height)

            if (isLeftToRight) {
                dfs(node.left, height + 1, isLeftToRight)
                dfs(node.right, height + 1, isLeftToRight)
            } else {
                dfs(node.right, height + 1, isLeftToRight)
                dfs(node.left, height + 1, isLeftToRight)
            }
        }

        dfs(root, 0)
        maxHeight = 0
        dfs(root, 0, false)

        val answer = IntArray(queries.size)
        for (i in queries.indices) {
            answer[i] = heights[queries[i]]
        }

        return answer
    }
}