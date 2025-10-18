class Solution {
    fun maxDistinctElements(nums: IntArray, k: Int): Int {
        val sorted = nums.sorted()
        var last = -1000000000
        var answer = 0
        for (num in sorted) {
            val min = num - k
            if (last < min) {
                last = min
                answer++
                continue
            }

            val max = num + k
            if (min <= last && last < max) {
                last = last + 1
                answer++
            }
        }

        return answer
    }
}