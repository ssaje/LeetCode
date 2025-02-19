class Solution {
    fun getHappyString(n: Int, k: Int): String = buildString {
        var count = 1 shl (n - 1)
        if (count * 3 < k) {
            return ""
        }

        var rest = k
        if (rest <= count) {
            append('a')
            rest -= 1
        } else if (rest <= 2 * count) {
            append('b')
            rest -= 1 + count
        } else {
            append('c')
            rest -= 1 + 2 * count
        }

        count /= 2
        while (count > 0) {
            val ch = ('a'..'c').filter { it != this.last() }.let {
                if (rest < count) {
                    it[0]
                } else {
                    rest -= count
                    it[1]
                }
            }
            append(ch)
            count /= 2
        }
    }
}