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
    fun balanceBST(root: TreeNode?): TreeNode? {
        val sorted = mutableListOf<Int>()
        
        fun inorder(node: TreeNode?) {
            if (node == null) return
            inorder(node.left)
            sorted += node.`val`
            inorder(node.right)
        }

        inorder(root)

        fun build(l: Int, r: Int): TreeNode? {
            if (l > r) return null
            else if (l == r) return TreeNode(sorted[l])

            val m = l + (r - l) / 2
            val node = TreeNode(sorted[m])
            node.left = build(l, m - 1)
            node.right = build(m + 1, r)
            return node
        }

        return build(0, sorted.size - 1)
    }
}