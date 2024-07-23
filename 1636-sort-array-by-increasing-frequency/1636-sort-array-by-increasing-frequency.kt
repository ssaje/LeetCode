class Solution {
    fun frequencySort(nums: IntArray): IntArray {
        return nums
            .asList()
            .groupingBy { it }
            .eachCount()
            .toList()
            .sortedWith(
                compareBy<Pair<Int, Int>> { it.second }
                    .thenByDescending { it.first }
            )
            .flatMap { IntArray(it.second) { _ -> it.first }.asIterable() }
            .toIntArray()
    }
}