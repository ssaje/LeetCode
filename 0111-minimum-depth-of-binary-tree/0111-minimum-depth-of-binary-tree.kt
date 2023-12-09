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
    fun minDepth(root: TreeNode?): Int {
        return root.getDepth()
    }

    private fun TreeNode?.getDepth(): Int {
        if (this == null) {
            return 0
        } else if (this.left == null) {
            return 1 + this.right.getDepth()
        } else if (this.right == null) {
            return 1 + this.left.getDepth()
        }

        return 1 + minOf(this.left.getDepth(), this.right.getDepth())
    }
}