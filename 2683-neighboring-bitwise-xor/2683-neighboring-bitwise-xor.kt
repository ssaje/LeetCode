class Solution {
    fun doesValidArrayExist(derived: IntArray): Boolean {
        return derived.fold(0) { acc, value -> acc xor value } == 0
    }
}