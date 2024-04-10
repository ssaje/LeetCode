class Solution {
    fun deckRevealedIncreasing(deck: IntArray): IntArray {
        val sorted = deck.sorted()
        var i = 0
        val answer = IntArray(deck.size)
        for (j in 0..<sorted.lastIndex) {
            answer[i] = sorted[j]

            while (answer[i] != 0) {
                i = (i + 1) % sorted.size
            }

            if (j + 1 == sorted.lastIndex) {
                break
            }

            do {
                i = (i + 1) % sorted.size
            } while (answer[i] != 0)
        }

        answer[i] = sorted.last()

        return answer
    }
}