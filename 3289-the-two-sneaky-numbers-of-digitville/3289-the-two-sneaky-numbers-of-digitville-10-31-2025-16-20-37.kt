class Solution {
    fun getSneakyNumbers(nums: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        val freqs = nums.asIterable().groupingBy { it }.eachCount()
        for ((key, value) in freqs) {
            if (value == 2) {
                answer += key
            }
        }

        return answer.toIntArray()
    }
}