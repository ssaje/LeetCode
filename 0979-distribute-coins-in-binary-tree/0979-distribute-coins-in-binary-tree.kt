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
    fun distributeCoins(root: TreeNode?): Int {
        fun dfs(node: TreeNode?): Pair<Int, Int> {
            if (node == null) {
                return 0 to 0
            }

            val left = dfs(node.left)
            val right = dfs(node.right)

            val count = left.second + right.second + 1 - node.`val`
            val moves = left.first + right.first + count.absoluteValue

            return moves to count
        }

        return dfs(root).first
    }
}