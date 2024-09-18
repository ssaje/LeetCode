class Solution {
    fun largestNumber(nums: IntArray): String {
        val answer = nums.map { it.toString() }.sortedWith { a, b -> (b + a).compareTo(a + b) }.joinToString("")
        if (answer[0] == '0') {
            return "0"
        }

        return answer
    }
}