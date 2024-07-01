class Solution {
    fun threeConsecutiveOdds(arr: IntArray): Boolean {
        for (i in 2..arr.lastIndex) {
            val isEveryOdd = arr.slice(i-2..i).all { it % 2 == 1 }
            if (isEveryOdd) {
                return true
            }
        }

        return false
    }
}