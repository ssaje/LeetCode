class Solution {
    fun checkValidString(s: String): Boolean {
        var count = 0
        var starCount = 0
        for (ch in s) {
            if (ch == '(') {
                count++
            } else if (ch == ')') {
                count--
            } else {
                starCount++
            }
            
            if (count < 0) {
                if (starCount == 0) {
                    return false
                } else {
                    count++
                    starCount--
                }
            }
        }

        count = 0
        starCount = 0
        for (i in s.lastIndex downTo 0) {
            val ch = s[i]
            if (ch == ')') {
                count++
            } else if (ch == '(') {
                count--
            } else {
                starCount++
            }
            
            if (count < 0) {
                if (starCount == 0) {
                    return false
                } else {
                    count++
                    starCount--
                }
            }
        }

        return true
    }
}