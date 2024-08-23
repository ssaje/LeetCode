class Solution {
    fun fractionAddition(expression: String): String {
        var a = 0L
        var b = 1L

        var c = 0
        var d = 0
        var isPositive = true
        var isNumeratorParsed = false

        fun sum() {
            if (d == 0) {
                return
            }

            // a/b + c/d == (ad + bc) / (bd)
            val sign = if (isPositive) {
                1
            } else {
                -1
            }

            val e = a * d + b * c * sign
            val f = b * d
            val divisor = gcd(e, f)
            a = e / divisor
            b = f / divisor
        }

        for (ch in expression) {
            if (ch == '+' || ch == '-') {
                sum()
                
                c = 0
                d = 0
                isPositive = ch == '+'
                isNumeratorParsed = false
            } else if (ch == '/') {
                isNumeratorParsed = true
            } else if (isNumeratorParsed) {
                d = d * 10 + ch.digitToInt()
            } else {
                c = c * 10 + ch.digitToInt()
            }
        }

        sum()

        val sign = if (a * b < 0) {
            -1
        } else {
            1
        }

        return "${sign * a.absoluteValue}/${b.absoluteValue}"
    }

    private fun gcd(a: Long, b: Long): Long {
        if (b == 0L) {
            return a
        }

        return gcd(b, a % b)
    }
}