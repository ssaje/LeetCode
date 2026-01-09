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
    fun subtreeWithAllDeepest(root: TreeNode?): TreeNode? {
        fun dfs(node: TreeNode?): Pair<TreeNode?, Int> {
            if (node == null) return null to 0

            val l = dfs(node.left)
            val r = dfs(node.right)

            return when {
                l.second > r.second -> l.first to (l.second + 1)
                l.second < r.second -> r.first to (r.second + 1)
                else -> node to (l.second + 1)
            }
        }

        return dfs(root).first
    }
}