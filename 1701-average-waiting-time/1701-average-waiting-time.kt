class Solution {
    fun averageWaitingTime(customers: Array<IntArray>): Double {
        var currentTime = 0
        var sum = 0L
        for (customer in customers) {
            val (arrival, time) = customer
            if (currentTime < arrival) {
                currentTime = arrival + time
            } else {
                currentTime += time
            }

            sum += currentTime - arrival
        }

        return sum / customers.size.toDouble()
    }
}