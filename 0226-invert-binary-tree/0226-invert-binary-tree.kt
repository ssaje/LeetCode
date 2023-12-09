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
    fun invertTree(root: TreeNode?): TreeNode? {
        return root?.reverse()
    }

    private fun TreeNode.reverse(): TreeNode {
        this.left = this.right.also {
            this.right = this.left
        }

        this.left?.reverse()
        this.right?.reverse()

        return this
    }
}