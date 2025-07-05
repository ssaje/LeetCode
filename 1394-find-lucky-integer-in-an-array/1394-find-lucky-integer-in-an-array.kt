class Solution {
    fun findLucky(arr: IntArray): Int {
        val counts = IntArray(501)
        for (element in arr) {
            counts[element]++
        }

        for (i in 500 downTo 1) {
            if (counts[i] == i) return i
        }

        return -1
    }
}