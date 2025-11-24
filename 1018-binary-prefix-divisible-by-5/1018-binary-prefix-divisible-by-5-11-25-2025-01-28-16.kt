class Solution {
    fun prefixesDivBy5(nums: IntArray): List<Boolean> {
        var current = 0
        return nums.map { num ->
            current = (current * 2 + num) % 5
            current == 0
        }
    }
}