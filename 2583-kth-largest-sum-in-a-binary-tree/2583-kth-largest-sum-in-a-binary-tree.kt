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
    fun kthLargestLevelSum(root: TreeNode?, k: Int): Long {
        if (root == null) {
            return -1
        }

        val levelSums = LongArray(100_000)
        fun dfs(node: TreeNode, level: Int) {
            levelSums[level] += node.`val`.toLong()
            node.left?.let { dfs(it, level + 1) }
            node.right?.let { dfs(it, level + 1) }
        }

        dfs(root, 0)

        return levelSums.sortedDescending()[k - 1].takeIf { it != 0L } ?: -1
    }
}