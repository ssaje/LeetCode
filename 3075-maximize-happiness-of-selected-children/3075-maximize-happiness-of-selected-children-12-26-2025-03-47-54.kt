class Solution {
    fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
        var time = 0
        var answer = 0L

        val sliced = happiness
            .sorted()
            .slice(happiness.size-k..happiness.lastIndex)
        
        sliced.forEachIndexed { index, value ->
            val rest = value - time
            if (rest < sliced.lastIndex - index) {
                return@forEachIndexed
            }

            answer += rest
            ++time
        }

        return answer
    }
}