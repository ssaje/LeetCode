class Solution {
    fun buyChoco(prices: IntArray, money: Int): Int {
        var first = Int.MAX_VALUE
        var second = Int.MAX_VALUE
        for (price in prices) {
            if (first > price) {
                second = first
                first = price
            } else if (second > price) {
                second = price
            }
        }

        return (first + second).let {
            if (it > money) {
                money
            } else {
                money - it
            }
        }
    }
}