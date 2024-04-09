class Solution {
    fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
        var time = 0
        while (true) {
            for (i in tickets.indices) {
                if (tickets[i] == 0) {
                    continue
                }

                time++
                tickets[i]--
                if (i == k && tickets[i] == 0) {
                    return time
                }
            }
        }

        return -1
    }
}