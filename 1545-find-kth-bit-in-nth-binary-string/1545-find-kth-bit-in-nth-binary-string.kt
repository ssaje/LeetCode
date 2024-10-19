class Solution {
    fun findKthBit(n: Int, k: Int): Char {
        val sb = StringBuilder("0")
        repeat(n - 1) {
            val toBeAppended = sb.map { if (it == '0') '1' else '0' }.joinToString("").reversed()
            sb.append("1")
            sb.append(toBeAppended)
        }

        return sb[k - 1]
    }
}