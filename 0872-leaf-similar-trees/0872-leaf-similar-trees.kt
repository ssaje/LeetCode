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
        val acc1 = arrayListOf<Int>()
        val acc2 = arrayListOf<Int>()

        root1?.getLeafValueSequence(acc1)
        root2?.getLeafValueSequence(acc2)

        return acc1 == acc2
    }

    private fun TreeNode?.getLeafValueSequence(acc: ArrayList<Int>) {
        if (this != null) {
            if (this.left == null && this.right == null) {
                acc += this.`val`
            }
            
            if (this.left != null) {
                this.left.getLeafValueSequence(acc)
            }

            if (this.right != null) {
                this.right.getLeafValueSequence(acc)
            }
        }
    }
}