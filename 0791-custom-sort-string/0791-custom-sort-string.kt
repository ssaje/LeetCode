class Solution {
    fun customSortString(order: String, s: String): String {
        val counts = IntArray('z' - 'a' + 1)
        for (ch in s) {
            counts[ch - 'a']++
        }

        return buildString {
            for (ch in order) {
                val count = counts[ch - 'a']
                this.append(ch.toString().repeat(count))
            }

            val check = order.toSet()
            this.append(s.filter { it !in check })
        }
    }
}