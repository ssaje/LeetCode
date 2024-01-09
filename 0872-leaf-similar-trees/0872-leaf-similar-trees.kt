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
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        return root1.getLeafValueSequence(arrayListOf()) == root2.getLeafValueSequence(arrayListOf())
    }

    private fun TreeNode?.getLeafValueSequence(acc: ArrayList<Int>): ArrayList<Int> {
        if (this == null) {
            return acc
        }

        if (this.left == null && this.right == null) {
            acc += this.`val`
        }
        
        if (this.left != null) {
            this.left.getLeafValueSequence(acc)
        }

        if (this.right != null) {
            this.right.getLeafValueSequence(acc)
        }

        return acc
    }
}