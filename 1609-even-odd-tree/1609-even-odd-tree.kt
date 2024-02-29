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
    fun isEvenOddTree(root: TreeNode?): Boolean {
        val queue = ArrayDeque<Pair<Int, TreeNode>>()
        queue.addLast(0 to root!!)

        var level = 0
        while (queue.isNotEmpty()) {
            var last = if (level % 2 == 0) Int.MIN_VALUE else Int.MAX_VALUE
            while(queue.firstOrNull()?.first == level) {
                val (_, node) = queue.removeFirst()
                if (level % 2 == 0 && last >= node.`val`) {
                    return false
                } else if (level % 2 == 0 && node.`val` % 2 == 0) {
                    return false
                }

                if (level % 2 == 1 && last <= node.`val`) {
                    return false
                } else if (level % 2 == 1 && node.`val` % 2 == 1) {
                    return false
                }

                last = node.`val`

                if (node.left != null) {
                    queue.addLast(level + 1 to node.left)
                }

                if (node.right != null) {
                    queue.addLast(level + 1 to node.right)
                }
            }

            level++
        }

        return true
    }
}