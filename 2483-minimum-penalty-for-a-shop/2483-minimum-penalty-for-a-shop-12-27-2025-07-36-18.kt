class Solution {
    fun bestClosingTime(customers: String): Int {
        var ys = customers.count { it == 'Y' }
        var ns = 0
        var sum = ys

        var answer = 0
        var penalty = ys
        for (i in customers.indices) {
            val customer = customers[i]
            if (customer == 'Y') {
                ys--
            } else {
                ns++
            }

            if (penalty > ys + ns) {
                penalty = ys + ns
                answer = i + 1
            }
        }

        return answer
    }
}