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
    fun modifiedList(nums: IntArray, head: ListNode?): ListNode? {
        val numsSet = nums.toSet()
        val virtualHead = ListNode(0).apply { this.next = head }
        var node: ListNode? = virtualHead
        while (node?.next != null) {
            if (node.next.`val` in numsSet) {
                node.next = node.next.next
            } else {
                node = node.next
            }
        }

        return virtualHead.next
    }
}