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
    fun longestConsecutive(root: TreeNode?): Int {
        if (root == null) return 0

        // max, inc, dec
        fun dfs(node: TreeNode): IntArray {
            val answer = IntArray(3) { 1 }

            node.left?.let {
                val ret = dfs(it)
                answer[0] = maxOf(answer[0], ret[0])
                if (node.`val` == it.`val` + 1) {
                    answer[1] = maxOf(answer[1], ret[1] + 1)
                } else if (node.`val` + 1 == it.`val`) {
                    answer[2] = maxOf(answer[2], ret[2] + 1)
                }
            }
            
            node.right?.let {
                val ret = dfs(it)
                answer[0] = maxOf(answer[0], ret[0])
                if (node.`val` == it.`val` + 1) {
                    answer[1] = maxOf(answer[1], ret[1] + 1)
                } else if (node.`val` + 1 == it.`val`) {
                    answer[2] = maxOf(answer[2], ret[2] + 1)
                }
            }

            answer[0] = maxOf(answer[0], answer[1] + answer[2] - 1)

            return answer
        }

        return dfs(root)[0]
    }
}