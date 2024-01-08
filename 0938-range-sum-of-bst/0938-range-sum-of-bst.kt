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
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        return root?.sum(low..high) ?: 0
    }

    private fun TreeNode.sum(range: ClosedRange<Int>): Int {
        var acc = 0
        if (this.`val` in range) {
            acc += this.`val`
        }

        acc += this.left?.sum(range) ?: 0
        acc += this.right?.sum(range) ?: 0

        return acc
    }
}