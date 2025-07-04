class Solution {
    fun kthCharacter(k: Long, operations: IntArray): Char {
        var i = 0
        var count = 1L
        while (count < k) {
            i++
            count *= 2
        }

        var offset = 0
        var remained = k - 1
        while (remained > 0) {
            i--
            count /= 2
            
            if (remained < count) continue

            remained -= count
            if (operations[i] == 1) offset++
        }

        return 'a' + offset % 26
    }
}