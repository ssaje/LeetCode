class Solution {
    fun maxDistance(arrays: List<List<Int>>): Int {
        var min = arrays[0].first()
        var max = arrays[0].last()
        var answer = 0
        for (i in 1..arrays.lastIndex) {
            val array = arrays[i]
            val currentMin = array.first()
            val currentMax = array.last()

            answer = maxOf(
                answer,
                currentMax - min,
                max - currentMin,
            )

            min = min.coerceAtMost(currentMin)
            max = max.coerceAtMost(currentMax)
        }

        return answer
    }
}