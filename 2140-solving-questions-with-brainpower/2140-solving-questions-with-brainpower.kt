class Solution {
    fun mostPoints(questions: Array<IntArray>): Long {
        var answer = 0L
        val points = LongArray(questions.size)
        for (i in questions.indices) {
            val (point, brainpower) = questions[i]
            val current = point + points[i]
            answer = maxOf(current, answer)

            val next = i + brainpower + 1
            if (next < questions.size) {
                points[next] = maxOf(points[next], current)
            }
        }

        return answer
    }
}