class Solution {
    fun maxDiff(num: Int): Int {
        val str = num.toString()
        fun replaced(from: Char, to: Char): Int = buildString {
            for (ch in str) {
                append(if (ch == from) to else ch)
            }
        }.toInt()

        val none9 = str.firstOrNull { it != '9' } ?: ' '
        val max = replaced(none9, '9')        
        if (str[0] != '1') return max - replaced(str[0], '1')

        val none1Or0 = str.firstOrNull { it != '1' && it != '0' } ?: ' '
        val min = replaced(none1Or0, '0')

        return max - min
    }
}