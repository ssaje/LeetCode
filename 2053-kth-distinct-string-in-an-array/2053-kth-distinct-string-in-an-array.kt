class Solution {
    fun kthDistinct(arr: Array<String>, k: Int): String {
        val freqs = arr.groupingBy { it }.eachCount()

        var n = 0
        arr.forEach {
            if (freqs.getValue(it) == 1) {
                n++
            }

            if (n == k) {
                return it
            }
        }

        return ""
    }
}