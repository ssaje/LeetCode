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
    fun postorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) {
            return emptyList()
        }

        val stack = Stack<Pair<TreeNode, Boolean>>()
        val answer = mutableListOf<Int>()

        var count = 10
        stack += root to false
        while (stack.isNotEmpty()) {
            val (p, isReturned) = stack.pop()
            if (p.left == null && p.right == null) {
                answer += p.`val`
                continue
            }
            
            if (isReturned) {
                answer += p.`val`
            } else {
                stack += p to true
                p.right?.let { stack += it to false }
                p.left?.let { stack += it to false }
            }
        }

        return answer
    }
}