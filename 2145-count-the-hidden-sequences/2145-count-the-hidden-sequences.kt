class Solution {
    fun numberOfArrays(differences: IntArray, lower: Int, upper: Int): Int {
        var sum = 0L
        var min = 0L
        var max = 0L
        for (difference in differences) {
            sum += difference
            if (sum > max) {
                max = sum
            }

            if (sum < min) {
                min = sum
            }
        }

        if (max - min > upper - lower) return 0

        return (upper - lower - (max - min) + 1).toInt()
    }
}