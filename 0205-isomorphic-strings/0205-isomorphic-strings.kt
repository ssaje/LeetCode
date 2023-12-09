class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        val map = mutableMapOf<Char, Char>()
        val inverseMap = mutableMapOf<Char, Char>()
        for ((index, sch) in s.withIndex()) {
            val tch = t[index]
            val mapped = map[sch]
            if (mapped == null) {
                map[sch] = tch
            } else if (mapped != tch) {
                return false
            }

            val inverseMapped = inverseMap[tch]
            if (inverseMapped == null) {
                inverseMap[tch] = sch
            } else if (inverseMapped != sch) {
                return false
            }
        }

        return true
    }
}