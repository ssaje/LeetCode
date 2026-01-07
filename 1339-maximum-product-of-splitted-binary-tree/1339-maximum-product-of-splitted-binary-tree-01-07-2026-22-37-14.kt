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
    fun maxProduct(root: TreeNode?): Int {
        if (root == null) return 0

        var total = 0L
        fun sum(node: TreeNode) {
            total += node.`val`
            
            node.left?.let { sum(it) }
            node.right?.let { sum(it) }
        }

        sum(root)

        var answer = 0L
        fun dfs(node: TreeNode): Long {
            var sub = node.`val`.toLong()
            node.left?.let { sub += dfs(it) }
            node.right?.let { sub += dfs(it) }

            answer = maxOf(answer, sub * (total - sub))
            
            return sub
        }

        dfs(root)

        return answer.mod(1_000_000_007).toInt()
    }
}