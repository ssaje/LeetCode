class Solution {
    fun maxBottlesDrunk(numBottles: Int, numExchange: Int): Int {
        var answer = 0
        var full = numBottles
        var empty = 0
        var cost = numExchange
        while (full > 0) {
            answer += full
            
            empty += full
            full = 0

            while (empty >= cost) {
                empty -= cost
                cost++
                full++
            }
        }

        return answer
    }
}