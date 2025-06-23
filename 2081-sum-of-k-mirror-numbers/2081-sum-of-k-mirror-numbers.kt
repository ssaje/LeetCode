class Solution {
    fun kMirror(k: Int, n: Int): Long {
        fun isPalindrome(m: Long): Boolean {
            val baseK = m.toString(k)
            return baseK == baseK.reversed()
        }

        var answer = 0L
        var s = 1L
        var count = 0
        while (count < n) {
            val e = s * 10
            for (isEven in 0..1) {
                if (count == n) break

                for (i in s..<e) {
                    if (count == n) break

                    var palindrome = i
                    var rest = if (isEven == 1) i else i / 10
                    while (rest > 0) {
                        palindrome = palindrome * 10 + (rest % 10)
                        rest /= 10
                    }

                    if (isPalindrome(palindrome)) {
                        ++count
                        answer += palindrome
                    }
                }
            }

            s = e
        }

        return answer
    }
}