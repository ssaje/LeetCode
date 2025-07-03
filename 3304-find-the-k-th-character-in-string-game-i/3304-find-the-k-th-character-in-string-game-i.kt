class Solution {
    fun kthCharacter(k: Int): Char {
        return buildString {
            append('a')
            while (length < k) {
                for (i in 0..<length) {
                    if (length >= k) break
                    
                    append('a' + (this[i] - 'a' + 1) % 26)
                }
            }
        }[k - 1]
    }
}