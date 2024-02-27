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
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        return dfs(root).first
    }

    private fun dfs(root: TreeNode?): Pair<Int, Int> {
        if (root == null) {
            return 0 to -1
        }

        val left = dfs(root.left)
        val right = dfs(root.right)

        return maxOf(left.second + right.second + 2, left.first, right.first) to maxOf(left.second, right.second) + 1
    }
}