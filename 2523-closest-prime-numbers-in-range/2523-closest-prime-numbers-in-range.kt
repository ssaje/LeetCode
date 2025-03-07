class Solution {
    fun closestPrimes(left: Int, right: Int): IntArray {
        var last = -1
        val answer = intArrayOf(-1, 1_000_000)
        for (num in left..right) {
            if (isPrime(num)) {
                if (last != -1 && num - last < answer[1] - answer[0]) {
                    answer[0] = last
                    answer[1] = num
                }

                last = num
            }
        }

        return if (answer[0] != -1) {
            answer
        } else {
            intArrayOf(-1, -1)
        }
    }

    fun isPrime(num: Int): Boolean {
        if (num == 1) {
            return false
        }

        for (i in 2..sqrt(num.toDouble()).toInt()) {
            if (num % i == 0) {
                return false
            }
        }

        return true
    }
}