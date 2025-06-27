class Solution {
    fun longestSubsequenceRepeatedK(s: String, k: Int): String {
        val maxCount = s.length / k
        if (maxCount == 0) return ""

        val fs = IntArray(26)
        for (ch in s) {
            fs[ch - 'a']++
        }

        fun isRepeated(pattern: String, count: Int, si: Int, pi: Int): Boolean {
            if (count >= k) return true
            if (si == s.length) return false

            var c = count
            var i = si
            var j = pi
            while (i < s.length) {
                if (s[i] == pattern[j]) {
                    j++
                    if (j == pattern.length) {
                        c++
                        j = 0
                    }
                }

                i++
            }

            return isRepeated(pattern, c, i, j)
        }

        var answer = ""
        fun permutations(sb: StringBuilder = StringBuilder()) {
            val target = sb.toString()
            if ((target.length > answer.length || (target.length == answer.length && target > answer)) && isRepeated(target, 0, 0, 0)) {
                answer = target
            }

            if (sb.length == maxCount) return

            for (i in 25 downTo 0) {
                if (fs[i] < k) continue

                sb.append('a' + i)
                fs[i] -= k
                
                permutations(sb)

                sb.deleteAt(sb.length - 1)
                fs[i] += k
            }
        }

        permutations()

        return answer
    }
}