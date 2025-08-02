class Solution {
    fun minCost(basket1: IntArray, basket2: IntArray): Long {
        val counts = mutableMapOf<Int, Int>()
        for (fruit in basket1) {
            counts[fruit] = (counts[fruit] ?: 0) + 1
        }

        for (fruit in basket2) {
            counts[fruit] = (counts[fruit] ?: 0) + 1
        }

        var min = Int.MAX_VALUE
        for ((key, value) in counts) {
            if (value % 2 == 1) return -1
            counts[key] = value / 2
            min = minOf(min, key)
        }

        var sorted1 = basket1.asIterable().groupingBy { it }.eachCount().entries
            .asSequence()
            .filter { it.value > counts[it.key]!! }
            .flatMap { generateSequence { it.key }.take(it.value - counts[it.key]!!) }
            .toMutableList()
        if (sorted1.isEmpty()) return 0

        var sorted2 = basket2.asIterable().groupingBy { it }.eachCount().entries
            .asSequence()
            .filter { it.value > counts[it.key]!! }
            .flatMap { generateSequence { it.key }.take(it.value - counts[it.key]!!) }
            .toMutableList()

        sorted1.sort()
        sorted2.sort()

        var j = sorted2.size - 1
        var answer = 0L
        for (i in sorted1.indices) {
            answer += minOf(min*2, sorted1[i], sorted2[j])
            j--
        }

        return answer
    }
}