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
    fun getDecimalValue(head: ListNode?): Int {
        var node = head
        var answer = 0
        while (node != null) {
            answer *= 2
            answer += node.`val`
            node = node.next
        }

        return answer
    }
}