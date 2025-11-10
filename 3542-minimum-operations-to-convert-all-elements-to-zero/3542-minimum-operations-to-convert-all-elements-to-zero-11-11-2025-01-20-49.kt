class Solution {
    fun minOperations(nums: IntArray): Int {
        val stack = ArrayDeque<Int>()
        var answer = 0
        for (num in nums) {
            while (stack.isNotEmpty() && stack.last() > num) {
                stack.removeLast()
            }

            if (num == 0) continue

            if (stack.isEmpty() || stack.last() < num) {
                answer++
                stack.addLast(num)
            }
        }

        return answer
    }
}