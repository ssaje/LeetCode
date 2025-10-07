class Solution {
    fun avoidFlood(rains: IntArray): IntArray {
        val n = rains.size
        val answer = IntArray(n) { 1 }
        val full = mutableMapOf<Int, Int>()
        val empty = TreeSet<Int>()
        for (i in rains.indices) {
            val rain = rains[i]
            if (rain == 0) {
                empty.add(i)
                continue
            }

            answer[i] = -1

            if (rain in full) {
                val j = empty.higher(full[rain]!!)
                    ?: return intArrayOf()

                answer[j] = rain
                empty.remove(j)
            }

            full[rain] = i
        }

        return answer
    }
}