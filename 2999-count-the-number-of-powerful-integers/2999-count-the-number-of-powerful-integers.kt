class Solution {
    fun numberOfPowerfulInt(start: Long, finish: Long, limit: Int, s: String): Long {
        fun count(upperBound: Long): Long {
            val stringified = upperBound.toString()
            if (stringified.length < s.length) {
                return 0
            } else if (stringified.length == s.length) {
                return if (stringified < s) {
                    0
                } else {
                    1
                }
            }

            var answer = 0L
            val length = stringified.length - s.length
            val base = (limit + 1).toDouble()
            for (i in 0..<length) {
                val digit = stringified[i] - '0'
                if (digit > limit) {
                    return answer + base.pow(length - i).toLong()
                }

                answer += digit * base.pow(length - i - 1).toLong()
            }

            if (stringified.substring(length) >= s) {
                answer++
            }

            return answer
        }

        return count(finish) - count(start - 1)
    }
}