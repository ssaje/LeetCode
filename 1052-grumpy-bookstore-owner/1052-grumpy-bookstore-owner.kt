class Solution {
    fun maxSatisfied(customers: IntArray, grumpy: IntArray, minutes: Int): Int {
        var all = 0
        var sum = 0
        for (i in 0..<minutes) {
            if (grumpy[i] == 1) {
                sum += customers[i]
            } else {
                all += customers[i]
            }
        }

        var max = sum
        for (i in minutes..<customers.size) {
            if (grumpy[i - minutes] == 1) {
                sum -= customers[i - minutes]
            }

            if (grumpy[i] == 1) {
                sum += customers[i]
                if (max < sum) {
                    max = sum
                }
            } else {
                all += customers[i]
            }
        }

        return all + max
    }
}