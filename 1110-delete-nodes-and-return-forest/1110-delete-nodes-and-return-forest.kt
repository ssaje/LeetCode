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
        val valsToBeDeleted = to_delete.toHashSet()

        fun dfs(node: TreeNode?, insert: Boolean): TreeNode? {
            if (node == null) {
                return node
            }

            val isDeleted = node.`val` in valsToBeDeleted
            node.left = dfs(node.left, isDeleted)
            node.right = dfs(node.right, isDeleted)

            if (isDeleted) {
                return null
            } else if (insert) {
                trees += node
            }

            return node
        }

        dfs(root, true)

        return trees
    }
}