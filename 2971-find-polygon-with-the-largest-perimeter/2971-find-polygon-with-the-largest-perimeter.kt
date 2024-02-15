class Solution {
    fun largestPerimeter(nums: IntArray): Long {
        var sum = nums.sumOf { it.toLong() }
        for (num in nums.sortedDescending()) {
            if (sum > 2 * num) {
                return sum
            }

            sum -= num
        }

        return -1
    }
}