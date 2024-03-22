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
    fun isPalindrome(head: ListNode?): Boolean {
        val list = mutableListOf<Int>()
        var node = head
        while (node != null) {
            if (node.`val` != null) {
                list += node.`val`
            }

            node = node.next
        }

        return list == list.reversed()
    }
}