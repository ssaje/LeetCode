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
    fun spiralMatrix(m: Int, n: Int, head: ListNode?): Array<IntArray> {
        val answer = Array(m) { IntArray(n) { -1 } }
        
        var i = 0
        var j = -1
        var node = head
        while (node != null) {
            while (j + 1 < n && answer[i][j + 1] == -1 && node != null) {
                j++
                answer[i][j] = node.`val`
                node = node.next
            }

            while (i + 1 < m && answer[i + 1][j] == -1 && node != null) {
                i++
                answer[i][j] = node.`val`
                node = node.next
            }

            while (j - 1 >= 0 && answer[i][j - 1] == -1 && node != null) {
                j--
                answer[i][j] = node.`val`
                node = node.next
                if (node == null) {
                    return answer
                }
            }

            while (i - 1 >= 0 && answer[i - 1][j] == -1 && node != null) {
                i--
                answer[i][j] = node.`val`
                node = node.next
            }
        }

        return answer
    }
}