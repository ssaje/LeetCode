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
    fun reverseOddLevels(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }

        fun dfs(left: TreeNode?, right: TreeNode?, level: Int = 0): Pair<TreeNode?, TreeNode?> {
            if (left == null || right == null) {
                return null to null
            }

            val (leftVal, rightVal) = if (level % 2 == 0) {
                right.`val` to left.`val`
            } else {
                left.`val` to right.`val`
            }

            val (ll, rr) = dfs(left.left, right.right, level + 1)
            val (lr, rl) = dfs(left.right, right.left, level + 1)

            val l = TreeNode(leftVal).apply {
                this.left = ll
                this.right = lr
            }

            val r = TreeNode(rightVal).apply {
                this.left = rl
                this.right = rr
            }

            return l to r
        }

        val (l, r) = dfs(root?.left, root?.right)

        return TreeNode(root.`val`).apply {
            this.left = l
            this.right = r
        }
    }
}