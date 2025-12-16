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
    fun longestConsecutive(root: TreeNode?): Int {
        if (root == null) return 0

        fun dfs(node: TreeNode): Pair<Int, Int> {
            var a = 1
            var b = 1

            node.left?.let { 
                val (c, d) = dfs(it)
                if (it.`val` == node.`val` + 1) {
                    a = maxOf(a, 1 + c)
                }

                b = maxOf(b, d)
            }

            node.right?.let { 
                val (c, d) = dfs(it)
                if (it.`val` == node.`val` + 1) {
                    a = maxOf(a, 1 + c)
                }

                b = maxOf(b, d)
            }

            return a to maxOf(a, b)
        }

        return dfs(root).second
    }
}