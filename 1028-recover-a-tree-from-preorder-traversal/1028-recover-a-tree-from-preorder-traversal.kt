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
    fun recoverFromPreorder(traversal: String): TreeNode? {
        var from = 0

        fun node(): Int = buildString {
            while (from < traversal.length) {
                if (traversal[from] != '-') {
                    append(traversal[from])
                    from++
                } else {
                    break
                }
            }
        }.toInt()

        fun dash(): Int {
            var count = 0
            while (from < traversal.length) {
                if (traversal[from] == '-') {
                    count++
                    from++
                } else {
                    break
                }
            }

            return count
        }

        var d: Int? = null
        fun dfs(depth: Int): TreeNode {
            val u = TreeNode(node())

            val ld = dash()
            if (depth + 1 == ld) {
                d = null
                u.left = dfs(ld)
            } else {
                d = ld
                return u
            }

            val rd = d ?: dash()
            if (depth + 1 == rd) {
                d = null
                u.right = dfs(rd)
            } else {
                d = rd
            }

            return u
        }

        return dfs(0)
    }
}