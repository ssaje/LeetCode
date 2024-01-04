class Solution {
    fun minOperations(nums: IntArray): Int {
        return nums
            .asSequence()
            .groupingBy { it }
            .eachCount()
            .values
            .sumOf { count ->
                var rest = count
                for (i in 0..(count/2)) {
                    if (rest % 3 == 0) {
                        return@sumOf i + rest / 3
                    }

                    rest -= 2
                }

                return -1
            }
    }
}