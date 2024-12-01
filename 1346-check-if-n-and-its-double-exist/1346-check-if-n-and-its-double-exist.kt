class Solution {
    fun checkIfExist(arr: IntArray): Boolean {
        val set = arr.toSet()
        return arr.any { 2 * it in set }
    }
}