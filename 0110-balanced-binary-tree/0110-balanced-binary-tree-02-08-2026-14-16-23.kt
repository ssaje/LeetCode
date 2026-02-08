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
    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) return true

        val (hl, hr) = height(root)
        return if ((hl - hr).absoluteValue > 1) false else isBalanced(root.left) && isBalanced(root.right)
    }

    private fun height(node: TreeNode): Pair<Int, Int> {
        val hl = node.left?.let { height(it).max() + 1 } ?: 0
        val hr = node.right?.let { height(it).max() + 1 } ?: 0
        return hl to hr
    }

    private fun Pair<Int, Int>.max(): Int = maxOf(first, second)
}