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
    fun smallestFromLeaf(root: TreeNode?): String {
        var answer = ('z' + 1).toString()
        val stringBuilder = StringBuilder()

        fun dfs(node: TreeNode) {
            stringBuilder.append('a' + node.`val`)

            if (node.left == null && node.right == null) {
                val candidate = stringBuilder
                    .toString()
                    .reversed()
                if (answer > candidate) {
                    answer = candidate
                }
            } else {
                node.left?.let { dfs(it) }
                node.right?.let { dfs(it) }
            }

            stringBuilder.deleteAt(stringBuilder.length - 1)
        }

        dfs(root!!)

        return answer
    }
}