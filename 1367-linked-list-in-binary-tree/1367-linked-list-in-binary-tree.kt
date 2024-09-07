/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
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
    fun isSubPath(head: ListNode?, root: TreeNode?): Boolean {
        fun dfs(listNode: ListNode?, treeNode: TreeNode?, matching: Boolean): Boolean {
            if (listNode == null) {
                return true
            } else if (treeNode == null) {
                return false
            }

            if (listNode.`val` == treeNode.`val`) {
                val isMatched = dfs(listNode?.next, treeNode?.left, true) || dfs(listNode?.next, treeNode?.right, true)
                if (isMatched) {
                    return true
                }
            }
            
            if (matching) {
                return false
            }

            return dfs(listNode, treeNode?.left, false) || dfs(listNode, treeNode?.right, false)
        }

        return dfs(head, root, false)
    }
}