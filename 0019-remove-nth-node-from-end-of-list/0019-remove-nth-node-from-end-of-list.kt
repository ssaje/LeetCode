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
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val virtualHead = ListNode(-1).apply { this.next = head }
        var delayed: ListNode? = virtualHead
        var node: ListNode? = virtualHead
        
        repeat(n + 1) {
            node = node?.next
        }

        while (node != null) {
            node = node?.next
            delayed = delayed?.next
        }

        if (delayed != null) {
            delayed.next = delayed.next?.next
        }

        return virtualHead.next
    }
}