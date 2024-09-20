class Solution {
    fun shortestPalindrome(s: String): String {
        val str = "$s:${s.reversed()}"
        val f = IntArray(str.length)
        
        var i = 1
        var j = 0
        while (i < str.length) {
            if (str[i] == str[j]) {
                f[i] = j + 1
                i++
                j++
            } else if (j > 0) {
                j = f[j - 1]
            } else {
                i++
            }
        }

        val l = f[str.lastIndex]
        val suffix = s.substring(l).reversed()

        return "$suffix$s"
    }
}