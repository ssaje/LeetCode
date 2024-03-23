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
    fun reorderList(head: ListNode?): Unit {
        var slow = head
        var fast = head
        while (fast?.next?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }

        if (fast?.next != null) {
            slow = slow?.next
        }

        var reversed: ListNode? = null
        while (slow != null) {
            slow?.next = reversed.also {
                reversed = slow
                slow = slow?.next
            }
        }

        var node = head
        while (node != null && reversed != null) {
            node?.next = reversed.also {
                node = node?.next
            }

            reversed?.next = node.also {
                reversed = reversed?.next
            }
        }

        node?.next = reversed
    }
}