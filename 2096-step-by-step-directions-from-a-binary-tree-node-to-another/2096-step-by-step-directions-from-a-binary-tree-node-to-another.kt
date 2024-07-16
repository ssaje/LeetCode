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
    fun getDirections(root: TreeNode?, startValue: Int, destValue: Int): String {
        if (root == null) {
            return ""
        }
        
        fun dfs(u: TreeNode, target: Int, sb: StringBuilder, p: TreeNode? = null): Boolean {
            if (u.`val` == target) {
                return true
            }

            u.left?.let {
                sb.append('L')

                val isFinished = dfs(it, target, sb, u)
                if (isFinished) {
                    return true
                }

                sb.deleteAt(sb.length - 1)
            }

            u.right?.let {
                sb.append('R')

                val isFinished = dfs(it, target, sb, u)
                if (isFinished) {
                    return true
                }

                sb.deleteAt(sb.length - 1)
            }

            return false
        }

        val left = StringBuilder()
        dfs(root, startValue, left)

        val right = StringBuilder()
        dfs(root, destValue, right)

        var prefixIndex = 0
        while (prefixIndex < left.length && prefixIndex < right.length) {
            if (left[prefixIndex] != right[prefixIndex]) {
                break
            }

            prefixIndex++
        }

        return "U".repeat(left.length - prefixIndex) + right.substring(prefixIndex)
    }
}