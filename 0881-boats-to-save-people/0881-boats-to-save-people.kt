class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        val sorted = people.sorted()

        var answer = 0
        var s = 0
        var e = people.lastIndex
        while (s < e) {
            if (sorted[s] + sorted[e] <= limit) {
                s++
                e--
            } else {
                e--
            }

            answer++
        }

        if (s <= e) {
            answer++
        }

        return answer
    }
}