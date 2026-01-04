class Solution {
    fun sumFourDivisors(nums: IntArray): Int {
        return nums.sumOf { sum(it) }
    }

    fun sum(n: Int): Int {
        var ret = 0
        var count = 0
        for (i in 1..sqrt(n.toDouble()).toInt()) {
            if (n % i == 0) {
                count++
                ret += i
                if (n / i != i) {
                    count++
                    ret += n / i
                }

                if (count > 4) return 0
            }
        }

        if (count < 4) return 0
        return ret
    }
}