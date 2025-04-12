class Solution {
    fun countGoodIntegers(n: Int, k: Int): Long {
        val isOdd = n % 2 == 1
        val halfPos = n / 2
        val candidates = mutableSetOf<String>()
        fun backtracking(pos: Int, sb: StringBuilder) {
            if (pos == halfPos) {
                if (isOdd) {
                    for (i in 0..9) {
                        val half = sb.toString()
                        val str = "$half$i${half.reversed()}"
                        if (str.toLong() % k != 0L) {
                            continue
                        }

                        val chars = str.toCharArray()
                        chars.sort()
                        candidates += String(chars)
                    }
                } else {
                    val half = sb.toString()
                    val str = "$half${half.reversed()}"
                    if (str.toLong() % k == 0L) {
                        val chars = str.toCharArray()
                        chars.sort()
                        candidates += String(chars)
                    }
                }

                return
            }

            val start = if (pos == 0) {
                '1'
            } else {
                '0'
            }

            for (i in start..'9') {
                sb.append(i)
                backtracking(pos + 1, sb)
                sb.deleteAt(sb.length - 1)
            }
        }

        backtracking(0, StringBuilder())

        val factorials = LongArray(n + 1)
        factorials[0] = 1
        for (i in 1..n) {
            factorials[i] = factorials[i - 1] * i
        }

        var answer = 0L
        for (candidate in candidates) {
            val counts = IntArray(10)
            for (ch in candidate) {
                counts[ch - '0']++
            }

            var permutation = (n - counts[0]) * factorials[n - 1]
            for (count in counts) {
                permutation /= factorials[count]
            }

            answer += permutation
        }

        return answer
    }
}