class Solution {
    fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
        val sorted = potions.sorted()

        fun lowerBound(target: Long): Int {
            var l = 0
            var r = sorted.size
            while (l < r) {
                val m = l + (r - l) / 2
                if (sorted[m] < target) l = m + 1
                else r = m
            }

            return l
        }

        val answer = IntArray(spells.size)
        
        for (i in spells.indices) {
            answer[i] = sorted.size - lowerBound((success + spells[i] - 1) / spells[i])
        }

        return answer
    }
}