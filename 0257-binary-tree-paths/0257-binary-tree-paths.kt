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
    fun binaryTreePaths(root: TreeNode?): List<String> {
        return root.getPaths()
    }

    private fun TreeNode?.getPaths(path: String = ""): List<String> {
        if (this == null) {
            return emptyList()
        }

        val mergedPath = path + "->${this.`val`}"
        if (this.left == null && this.right == null) {
            return listOf(mergedPath.drop(2))
        }

        return this.left.getPaths(mergedPath) + this.right.getPaths(mergedPath)
    }
}