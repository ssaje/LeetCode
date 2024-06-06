class Solution {
    fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
        if (hand.size % groupSize != 0) {
            return false
        }

        val counts = mutableMapOf<Int, Int>()
        for (card in hand) {
            counts[card] = (counts[card] ?: 0) + 1
        }

        val cards = hand.sorted().distinct()
        for (i in groupSize..cards.size) {
            val card = cards[i - groupSize]
            val min = counts[card]!!
            if (min == 0) {
                continue
            }

            for (j in 0..<groupSize) {
                val dec = (counts[card + j] ?: 0) - min
                if (dec < 0) {
                    return false
                }

                counts[card + j] = dec
            }
        }

        return counts.all { it.value == 0 }
    }
}