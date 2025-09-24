class Solution {
    fun fractionToDecimal(numerator: Int, denominator: Int): String {
        if (numerator == 0) return "0"

        return buildString {
            if (numerator < 0 && denominator > 0) append("-")
            else if (numerator > 0 && denominator < 0) append("-")

            var num = numerator.toLong().absoluteValue
            var denom = denominator.toLong().absoluteValue

            append(num / denom)
            num %= denom
            if (num == 0L) return@buildString
            else append(".")

            val indexesByNum = mutableMapOf<Long, Int>()
            while (num > 0) {
                if (num in indexesByNum) {
                    insert(indexesByNum[num]!!, "(")
                    append(")")
                    break
                }

                indexesByNum[num] = length
                num *= 10
                append(num / denom)
                num %= denom
            }
        }
    }
}