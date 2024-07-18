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
    fun countPairs(root: TreeNode?, distance: Int): Int {
        var answer = 0

        fun dfs(node: TreeNode?): List<Int> {
            if (node == null) {
                return emptyList()
            } else if (node.left == null && node.right == null) {
                return listOf(1)
            }

            val lds = dfs(node.left)
            val rds = dfs(node.right)

            var l = 0
            for (r in rds.lastIndex downTo 0) {
                val rd = rds[r]
                while (l < lds.size && lds[l] + rd <= distance) {
                    l++
                }

                if (rd < distance) {
                    answer += l
                }
            }

            return buildList {
                var i = 0
                var j = 0
                
                while (i < lds.size && j < rds.size) {
                    if (lds[i] + 1 >= distance || rds[j] + 1 >= distance) {
                        break
                    }

                    if (lds[i] < rds[j]) {
                        add(lds[i++] + 1)
                    } else {
                        add(rds[j++] + 1)
                    }
                }

                while (i < lds.size) {
                    if (lds[i] + 1 < distance) {
                        add(lds[i++] + 1)
                    } else {
                        break
                    }
                }

                while (j < rds.size) {
                    if (rds[j] + 1 < distance) {
                        add(rds[j++] + 1)
                    } else {
                        break
                    }
                }
            }
        }

        dfs(root)

        return answer
    }
}