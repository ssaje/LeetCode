class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val stack = ArrayDeque<Int>()
        val answers = IntArray(temperatures.size)
        for ((i, temperature) in temperatures.withIndex()) {
            while (stack.isNotEmpty()) {
                val j = stack.last()
                if (temperatures[j] >= temperature) {
                    break
                }

                answers[j] = i - j
                stack.removeLast()
            }

            stack.addLast(i)
        }

        return answers
    }
}