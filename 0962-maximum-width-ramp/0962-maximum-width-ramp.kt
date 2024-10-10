class Solution {
    fun maxWidthRamp(nums: IntArray): Int {
        var answer = 0
        val sorted = nums
            .withIndex()
            .sortedWith(
                compareBy(
                    { it.value },
                    { it.index },
                )
            )

        var min = nums.size
        for ((index, value) in sorted) {
            min = min.coerceAtMost(index)
            answer = answer.coerceAtLeast(index - min)
        }

        return answer
    }
}