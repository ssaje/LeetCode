class Solution {
    fun singleNumber(nums: IntArray): IntArray {
        return nums
            .asSequence()
            .groupingBy { it }
            .eachCount()
            .filter { it.value == 1 }
            .keys
            .toIntArray()
    }
}