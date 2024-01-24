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
    fun pseudoPalindromicPaths (root: TreeNode?, counts: Int = 0): Int {
        if (root == null) {
            return 0
        }

        val updatedCounts = counts xor (1 shl root.`val`)

        if (root.left == null && root.right == null) {
            return if (updatedCounts.countOneBits() <= 1) 1 else 0
        }

        return pseudoPalindromicPaths(root.left, updatedCounts) + pseudoPalindromicPaths(root.right, updatedCounts)
    }
}