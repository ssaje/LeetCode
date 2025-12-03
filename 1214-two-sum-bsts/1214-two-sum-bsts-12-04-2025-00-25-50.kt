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
    fun twoSumBSTs(root1: TreeNode?, root2: TreeNode?, target: Int): Boolean {
        if (root1 == null || root2 == null) return false

        val node1 = mutableSetOf<Int>()
        fun dfs1(node: TreeNode) {
            node1 += node.`val`
            node.left?.let { dfs1(it) }
            node.right?.let { dfs1(it) }
        }

        dfs1(root1)

        fun dfs2(node: TreeNode): Boolean {
            if ((target - node.`val`) in node1) return true
            if (node.left != null && dfs2(node.left)) return true
            if (node.right != null && dfs2(node.right)) return true

            return false
        }

        return dfs2(root2)
    }
}