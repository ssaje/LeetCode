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
        val iterator1 = root1.getLeafValueSequence().iterator()
        val iterator2 = root2.getLeafValueSequence().iterator()
        while (iterator1.hasNext() && iterator2.hasNext()) {
            if (iterator1.next() != iterator2.next()) {
                return false
            }
        }

        return iterator1.hasNext() == false && iterator2.hasNext() == false
    }

    private fun TreeNode?.getLeafValueSequence(): Sequence<Int> {
        if (this == null) {
            return sequenceOf()
        } else if (this.left == null && this.right == null) {
            return sequenceOf(this.`val`)
        }

        return this.left.getLeafValueSequence() + this.right.getLeafValueSequence()
    }
}