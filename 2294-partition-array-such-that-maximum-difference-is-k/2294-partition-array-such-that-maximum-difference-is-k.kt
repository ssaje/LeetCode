class Solution {
    fun partitionArray(nums: IntArray, k: Int): Int {
        val sorted = nums.sorted()
        var answer = 1
        var first = sorted[0]
        for (num in sorted) {
            if (num - first > k) {
                answer++
                first = num
            }
        }

        return answer
    }
}