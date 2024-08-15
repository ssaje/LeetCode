class Solution {
    fun lemonadeChange(bills: IntArray): Boolean {
        var fives = 0
        var tens = 0
        for (bill in bills) {
            when (bill) {
                5 -> fives++
                10 -> {
                    if (fives == 0) {
                        return false
                    } else {
                        fives--
                        tens++
                    }
                }
                20 -> {
                    if (tens >= 1 && fives >= 1) {
                        tens--
                        fives--
                    } else if (fives >= 3) {
                        fives -= 3
                    } else {
                        return false
                    }
                }
            }
        }

        return true
    }
}