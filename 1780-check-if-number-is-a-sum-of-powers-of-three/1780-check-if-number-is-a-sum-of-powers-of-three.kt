class Solution {
    fun checkPowersOfThree(n: Int): Boolean {
        return n.toString(3).all { it != '2' }
    }
}