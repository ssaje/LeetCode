class Solution {
    fun countOdds(low: Int, high: Int): Int {
        val answer = high - low + 1
        if (answer % 2 == 0) return answer / 2
        
        return answer / 2 + if (low % 2 == 0) 0 else 1
    }
}