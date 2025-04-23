class Solution {
    fun countLargestGroup(n: Int): Int {
        return (1..n).groupingBy { it.toString().sumOf { it.digitToInt() } }.eachCount().values.fold(0 to 0) { (size, count), value ->
            if (size < value) {
                value to 1
            } else if (size == value) {
                value to count + 1
            } else {
                size to count
            }
        }.second
    }
}