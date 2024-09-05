class Solution {
    fun missingRolls(rolls: IntArray, mean: Int, n: Int): IntArray {
        val m = rolls.size
        val sum = mean * (m + n) - rolls.sum()
        
        val divided = sum / n
        val rest = sum % n
        if (divided !in 1..6 || (divided == 6 && rest > 0)) {
            return intArrayOf()
        }

        val answer = IntArray(n) { divided }
        for (i in 0..<rest) {
            answer[i]++
        }

        return answer
    }
}