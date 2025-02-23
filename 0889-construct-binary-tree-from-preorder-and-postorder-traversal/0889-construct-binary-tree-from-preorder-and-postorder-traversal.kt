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
    fun constructFromPrePost(preorder: IntArray, postorder: IntArray): TreeNode? {
        var i = 0
        var j = 0
        
        fun dfs(): TreeNode {
            val value = preorder[i++]
            val u = TreeNode(value)

            if (postorder[j] != value) {
                u.left = dfs()
            }

            if (postorder[j] != value) {
                u.right = dfs()
            }

            j++

            return u
        }

        return dfs()
    }
}