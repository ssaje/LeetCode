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
    fun findBottomLeftValue(root: TreeNode?): Int {
        var maxDepth = 0
        var answer = root!!.`val`

        fun dfs(node: TreeNode, depth: Int) {
            if (node.left == null && maxDepth < depth) {
                maxDepth = depth
                answer = node.`val`
            }

            if (node.left != null) {
                dfs(node.left, depth + 1)
            }

            if (node.right != null) {
                dfs(node.right, depth + 1)
            }
        }

        dfs(root!!, 0)

        return answer
    }
}