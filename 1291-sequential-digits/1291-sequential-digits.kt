class Solution {
    fun sequentialDigits(low: Int, high: Int): List<Int> {
        var answers = mutableListOf<Int>()
        for (start in 1..9) {
            var current = start
            while (current <= high) {
                if (current >= low) {
                    answers += current
                }

                if (current % 10 == 9) {
                    break
                }

                current = current * 10 + current % 10 + 1
            }
        }

        return answers.sorted()
    }
}