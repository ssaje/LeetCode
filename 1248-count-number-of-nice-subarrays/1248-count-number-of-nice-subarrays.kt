class Solution {
    fun numberOfSubarrays(nums: IntArray, k: Int): Int {
        val deque = ArrayDeque<Int>()
        deque.addLast(-1)

        var sum = 0
        for ((index, num) in nums.withIndex()) {
            if (num % 2 == 1) {
                deque.addLast(index)
                if (deque.size > k + 1) {
                    deque.removeFirst()
                }
            }

            if (deque.size == k + 1) {
                sum += deque[1] - deque[0]
            }
        }

        return sum
    }
}