class Solution {
    fun longestSubarray(nums: IntArray, limit: Int): Int {
        val minHeap = PriorityQueue<Pair<Int, Int>> { a, b -> a.first - b.first }
        val maxHeap = PriorityQueue<Pair<Int, Int>> { a, b -> b.first - a.first }

        var s = 0
        var answer = 0
        for ((e, num) in nums.withIndex()) {
            minHeap.offer(num to e)
            maxHeap.offer(num to e)

            while (maxHeap.peek().first - minHeap.peek().first > limit) {
                s = maxHeap.peek().second.coerceAtMost(minHeap.peek().second) + 1

                while (maxHeap.peek().second < s) {
                    maxHeap.poll()
                }

                while (minHeap.peek().second < s) {
                    minHeap.poll()
                }
            }

            if (answer < e - s + 1) {
                answer = e - s + 1
            }
        }

        return answer
    }
}