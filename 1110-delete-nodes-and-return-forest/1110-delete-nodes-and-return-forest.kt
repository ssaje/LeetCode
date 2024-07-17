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
    fun delNodes(root: TreeNode?, to_delete: IntArray): List<TreeNode?> {
        val trees = mutableListOf<TreeNode>()
        val valsToBeDeleted = to_delete.toSet()

        fun dfs(node: TreeNode?, insert: Boolean): Boolean {
            if (node == null) {
                return false
            }
            
            val isDeleted = node.`val` in valsToBeDeleted
            if (!isDeleted && insert) {
                trees += node
            }

            if (dfs(node.left, isDeleted)) {
                node.left = null
            }
            
            if (dfs(node.right, isDeleted)) {
                node.right = null
            }

            return isDeleted
        }

        dfs(root, true)

        return trees
    }
}