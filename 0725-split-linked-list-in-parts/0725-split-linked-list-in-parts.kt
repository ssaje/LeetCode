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
    fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
        var n = 0
        var node = head
        while (node != null) {
            node = node?.next
            n++
        }

        val m = n / k
        var r = n % k
        
        val answer = Array<ListNode?>(k) { null }
        var i = 0
        
        node = head
        while (node != null) {
            val add = if (r > 0) {
                r--
                1
            } else {
                0
            }

            val preHead = ListNode(-1)
            var connector = preHead
            repeat(m + add) {
                connector.next = ListNode(node!!.`val`)
                connector = connector.next
                node = node!!.next
            }

            answer[i++] = preHead.next
        }

        return answer
    }
}