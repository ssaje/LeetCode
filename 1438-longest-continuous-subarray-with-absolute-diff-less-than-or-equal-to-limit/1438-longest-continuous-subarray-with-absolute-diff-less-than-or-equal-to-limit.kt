class Solution {
    fun longestSubarray(nums: IntArray, limit: Int): Int {
        val minHeap = PriorityQueue<Pair<Int, Int>> { a, b -> a.first - b.first }
        val maxHeap = PriorityQueue<Pair<Int, Int>> { a, b -> b.first - a.first }

        var s = 0
        var sum = 0
        var answer = 0
        for ((index, num) in nums.withIndex()) {
            while (minHeap.isNotEmpty()) {
                val min = minHeap.peek()
                if (min.second < s) {
                    minHeap.poll()
                } else if ((min.first - num).absoluteValue > limit) {
                    minHeap.poll()
                    
                    val nextS = s.coerceAtLeast(min.second + 1)
                    sum -= nextS - s
                    s = nextS
                } else {
                    break
                }
            }

            while (maxHeap.isNotEmpty()) {
                val max = maxHeap.peek()
                if (max.second < s) {
                    maxHeap.poll()
                } else if ((max.first - num).absoluteValue > limit) {
                    maxHeap.poll()

                    val nextS = s.coerceAtLeast(max.second + 1)
                    sum -= nextS - s
                    s = nextS
                } else {
                    break
                }
            }

            minHeap.offer(num to index)
            maxHeap.offer(num to index)

            sum++
            if (answer < sum) {
                answer = sum
            }
        }

        return answer
    }
}