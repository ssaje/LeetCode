/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun doubleIt(head: ListNode?): ListNode? {
        fun solve(node: ListNode?): Int {
            if (node == null) {
                return 0
            }

            val carry = solve(node.next)
            node.`val` *= 2
            node.`val` += carry

            val ret = node.`val` / 10
            node.`val` %= 10

            return ret
        }

        return when (val carry = solve(head)) {
            0 -> head
            else -> ListNode(carry).apply { this.next = head }
        }
    }
}