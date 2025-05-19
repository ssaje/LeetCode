class Solution {
    fun triangleType(nums: IntArray): String {
        val sorted = nums.sorted()

        return when {
            sorted[0] + sorted[1] <= sorted[2] -> "none"
            sorted[0] == sorted[1] && sorted[1] == sorted[2] -> "equilateral"
            sorted[0] != sorted[1] && sorted[1] != sorted[2] -> "scalene"
            else -> "isosceles"
        }
    }
}