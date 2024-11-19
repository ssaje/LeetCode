class Solution {
    fun decrypt(code: IntArray, k: Int): IntArray {
        if (k == 0) {
            return IntArray(code.size)
        }

        val diff = if (k > 0) 1 else -1

        return code.mapIndexed { index, value ->
            var sum = 0
            var i = index
            repeat(k.absoluteValue) {
                i = (i + diff + code.size) % code.size
                sum += code[i]
            }

            sum
        }.toIntArray()
    }
}